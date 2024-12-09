package hoanvan.datsanbong.com.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    EXISTED_PHONE_NUMBER(1002, "Số điện thoại đã được đăng ký", HttpStatus.CONFLICT),
    NOT_BLANK_PHONE_NUMBER(1003, "Số điện thoại không được để trống", HttpStatus.BAD_REQUEST),
    INVALID_LENGTH_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_PHONE_NUMBER(1005, "Số điện thoại chưa được đăng ký", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    CONVERTER_NOT_FOUND(1009, "Converter not found", HttpStatus.BAD_REQUEST),
    NOT_BLANK_PASSWORD(1010, "Mật khẩu không được để trống", HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD(1011, "Mật khẩu không đúng", HttpStatus.BAD_REQUEST),
    NOT_FOUND_SAN(1012, "Không tìm thấy sân", HttpStatus.NOT_FOUND),
    NOT_FOUND_DON_DAT(1013, "Không tồn tại đơn đặt", HttpStatus.NOT_FOUND),
    NOT_FOUND_HOA_DON(1014, "Không tồn tại hóa đơn", HttpStatus.NOT_FOUND),
    EXISTED_CHI_TIET_DON_DAT(1015, "Sân đã được đặt", HttpStatus.BAD_REQUEST),
    INVALID_PHONE_NUMBER(1016, "Số điện thoại không hợp lệ", HttpStatus.BAD_REQUEST),
    FAILED_TO_UPLOAD_FILE(1017, "Tải hình ảnh bị lỗi", HttpStatus.BAD_REQUEST),
    NOT_BLANK_TEN_SAN(1018, "Tên sân không được để trống", HttpStatus.BAD_REQUEST),
    NOT_BLANK_DIA_CHI(1019, "Địa chỉ không được để trống", HttpStatus.BAD_REQUEST),
    INVALID_TAO_SAN(1020, "Sân đã tồn tại", HttpStatus.BAD_REQUEST),
    MAX_SIZE_FILE(1021, "File tải lên quá lớn", HttpStatus.BAD_REQUEST)
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
