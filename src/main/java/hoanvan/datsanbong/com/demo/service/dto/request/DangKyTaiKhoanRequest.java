package hoanvan.datsanbong.com.demo.service.dto.request;

import hoanvan.datsanbong.com.demo.entity.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class DangKyTaiKhoanRequest {
    @NotBlank(message = "NOT_BLANK_PHONE_NUMBER")
    @Pattern(
            regexp = "^(0\\d{9,10})$", // Regex cho số điện thoại bắt đầu bằng 0 và có 10-11 chữ số
            message = "INVALID_PHONE_NUMBER" // Thông báo lỗi khi không khớp với regex
    )
    String soDienThoai;

    @NotBlank(message = "NOT_BLANK_PASSWORD")
    String matKhau;

    String hoTen;
    AccountType loaiTaiKhoan = AccountType.KHACHHANG;
    Long sanId;
    Boolean trangThai = true;
}
