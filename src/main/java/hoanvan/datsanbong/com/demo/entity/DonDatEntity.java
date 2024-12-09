package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_dondat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonDatEntity extends AbstractAuditingEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "khachHangId")
    Long khachHangId;

    @Column(name = "soLuong", nullable = false)
    int soLuong;

    @Column(name = "tongTien", nullable = false)
    Long tongTien = 0L;

    @Column(name = "chuaThanhToan", nullable = false)
    Long chuaThanhToan = 0L;

    @Column(name = "sanId", nullable = true)
    Long sanId;
}
