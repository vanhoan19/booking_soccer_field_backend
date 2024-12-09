package hoanvan.datsanbong.com.demo.entity;

import hoanvan.datsanbong.com.demo.entity.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_taikhoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanEntity extends AbstractAuditingEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "soDienThoai", unique = true, updatable = false, length = 15)
    String soDienThoai;

    @Column(name = "matKhau", columnDefinition = "TEXT")
    String matKhau;

    @Column(name = "hoTen")
    String hoTen;

    @Enumerated(EnumType.STRING)
    @Column(name = "loaiTaiKhoan")
    AccountType loaiTaiKhoan = AccountType.KHACHHANG;

    @Column(name = "sanId", nullable = true)
    Long sanId; // dành cho chủ sân, khách hàng hoặc admin -> null

    @Column(name = "trangThai")
    Boolean trangThai = true;
}
