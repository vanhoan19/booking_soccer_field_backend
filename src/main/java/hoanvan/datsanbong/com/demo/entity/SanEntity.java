package hoanvan.datsanbong.com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalTime;

@Entity
@Table(name = "tbl_san")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "tenSan", nullable = false)
    String tenSan;

    @Column(name = "diaChi")
    String diaChi;

    @Column(name = "hinhAnhMain")
    String hinhAnhMain;

    @Column(name = "hinhAnhDetail", columnDefinition = "TEXT")
    String hinhAnhDetail;

    @Column(name = "soDienThoai")
    String soDienThoai;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "parentId", nullable = true)
    Long parentId;

    @Column(name = "trangThai")
    Boolean trangThai = true;
}
