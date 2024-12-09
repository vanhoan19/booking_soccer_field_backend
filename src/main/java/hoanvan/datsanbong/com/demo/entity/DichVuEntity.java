package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "tbl_dichvu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DichVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "tenDichVu", nullable = false)
    String tenDichVu;

    @Column(name = "sanId", nullable = true)
    Long sanId;

    @Column(name = "donVi")
    String donVi;

    @Column(name = "gia")
    Long gia;
}
