package hoanvan.datsanbong.com.demo.service.dto.response;

import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.HoaDonDto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DatSanResponse {
    Long donDatId;
    Long khachHangId;
    int soLuong;
    List<ChiTietDonDatDto> chiTietDonDats;
    HoaDonDto hoaDon;
    Long tongTien;
    Long chuaThanhToan;
    Long sanId;
}
