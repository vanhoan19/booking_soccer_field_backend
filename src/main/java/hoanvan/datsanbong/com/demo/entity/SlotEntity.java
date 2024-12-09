package hoanvan.datsanbong.com.demo.entity;

import hoanvan.datsanbong.com.demo.entity.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_slot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "sanId", nullable = false)
    Long sanId;

    @Column(name = "caId", nullable = false)
    Long caId;

    @Enumerated(EnumType.STRING)
    @Column(name = "dayOfWeek")
    DayOfWeek dayOfWeek;

    @Column(name = "gia")
    Long gia;

    @Column(name = "parentSanId")
    Long parentSanId;
}
