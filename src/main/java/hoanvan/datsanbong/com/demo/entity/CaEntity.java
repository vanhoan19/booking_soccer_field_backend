package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalTime;

@Entity
@Table(name = "tbl_ca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "gioBatDau")
    LocalTime gioBatDau;

    @Column(name = "gioKetThuc")
    LocalTime gioKetThuc;

    @Column(name = "sanId", nullable = true)
    Long sanId;
}
