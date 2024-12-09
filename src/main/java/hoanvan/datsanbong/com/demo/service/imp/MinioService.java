package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.exception.AppException;
import hoanvan.datsanbong.com.demo.exception.ErrorCode;
import io.minio.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class MinioService {

    private final MinioClient minioClient;
    private final String bucketName;

    public MinioService(
            @Value("${minio.endpoint}") String endpoint,
            @Value("${minio.accessKey}") String accessKey,
            @Value("${minio.secretKey}") String secretKey,
            @Value("${minio.bucketName}") String bucketName) {

        this.minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();

        this.bucketName = bucketName;
        createBucketIfNotExists();
    }

    // Kiểm tra và tạo bucket nếu chưa tồn tại
    private void createBucketIfNotExists() {
        try {
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());

                final var policy = """
                        {
                          "Version": "2012-10-17",
                          "Statement": [
                           {
                              "Effect": "Allow",
                              "Principal": "*",
                              "Action": "s3:GetObject",
                              "Resource": "arn:aws:s3:::%s/*"
                            }
                          ]
                        }
                    """.formatted(bucketName);

                minioClient.setBucketPolicy(
                        SetBucketPolicyArgs.builder().bucket(bucketName).config(policy).build()
                );

                System.out.println("Bucket " + bucketName + " đã được tạo.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Không thể tạo bucket.", e);
        }
    }

    // Upload file lên MinIO
    public String uploadFile(MultipartFile file) {
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .contentType(Objects.isNull(file.getContentType()) ? "image/png; image/jpg;" : file.getContentType())
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

        } catch (Exception e) {
            throw new AppException(ErrorCode.FAILED_TO_UPLOAD_FILE);
        }

        return String.format("http://%s/%s/%s", "localhost:9000", bucketName, fileName);
    }
}

