package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_chitiethoadon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietHoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "hoaDonId")
    Long hoaDonId;

    @Column(name = "dichVuId")
    Long dichVuId;

    @Column(name = "soLuong")
    int soLuong;

    @Column(name = "thanhTien", nullable = false)
    Long thanhTien = 0L;

    @Column(name = "sanId")
    Long sanId;
}
