package hoanvan.datsanbong.com.demo.service.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SanDto {
    Long id;
    String tenSan;
    String soDienThoai;
    String diaChi;
    String hinhAnhMain;
    String hinhAnhDetail;
    String description;
    Long parentId;
    Boolean trangThai = true;
}
