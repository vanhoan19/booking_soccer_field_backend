package hoanvan.datsanbong.com.demo.service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatSanRequest {
    List<ChiTietDonDatRequest> chitietDonDats;
    Long khachHangId;
    Long tongTien;
    Long sanId;
}
