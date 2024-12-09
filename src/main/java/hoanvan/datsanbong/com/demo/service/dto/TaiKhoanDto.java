package hoanvan.datsanbong.com.demo.service.dto;

import hoanvan.datsanbong.com.demo.entity.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanDto {
    Long id;
    String soDienThoai;
    String hoTen;
    AccountType loaiTaiKhoan;
    Long sanId;
    Boolean trangThai;
}
