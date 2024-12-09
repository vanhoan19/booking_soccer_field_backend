package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_hoadon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDonEntity extends AbstractAuditingEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "donDatId")
    Long donDatId;

    @Column(name = "tongTien", nullable = false)
    Long tongTien = 0L;

    @Column(name = "daThanhToan", nullable = false)
    Long daThanhToan = 0L;

    @Column(name = "sanId")
    Long sanId;
}
