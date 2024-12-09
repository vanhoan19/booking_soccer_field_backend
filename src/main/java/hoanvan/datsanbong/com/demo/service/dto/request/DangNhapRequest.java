package hoanvan.datsanbong.com.demo.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class DangNhapRequest {
    @NotBlank(message = "NOT_BLANK_PHONE_NUMBER")
    String soDienThoai;

    @NotBlank(message = "NOT_BLANK_PASSWORD")
    String matKhau;
}
