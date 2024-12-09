package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Entity
@Table(name = "tbl_chitietdondat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietDonDatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "donDatId")
    Long donDatId;

    @Column(name = "slotId")
    Long slotId;

    @Column(name = "ngayDat")
    Date ngayDat;

    @Column(name = "sanId", nullable = true)
    Long sanId;
}
