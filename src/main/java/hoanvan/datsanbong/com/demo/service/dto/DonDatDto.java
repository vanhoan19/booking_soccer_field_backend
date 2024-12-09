package hoanvan.datsanbong.com.demo.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonDatDto {
    Long id;
    Long khachHangId;
    int soLuong;
    Long tongTien;
    Long chuaThanhToan;
    Long sanId;
}
