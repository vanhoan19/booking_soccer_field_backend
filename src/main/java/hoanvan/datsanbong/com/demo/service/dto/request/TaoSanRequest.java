package hoanvan.datsanbong.com.demo.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaoSanRequest {
    @NotBlank(message = "NOT_BLANK_TEN_SAN")
    String tenSan;

    @NotBlank(message = "NOT_BLANK_DIA_CHI")
    String diaChi;

    @NonNull
    MultipartFile hinhAnhMain;
    List<MultipartFile> hinhAnhDetails = new ArrayList<>();

    @NotBlank(message = "NOT_BLANK_PHONE_NUMBER")
    @Pattern(
            regexp = "^(0\\d{9,10})$", // Regex cho số điện thoại bắt đầu bằng 0 và có 10-11 chữ số
            message = "INVALID_PHONE_NUMBER" // Thông báo lỗi khi không khớp với regex
    )
    String soDienThoai;
    String description;
    Long parentId;
    Boolean trangThai = true;
}
