package hoanvan.datsanbong.com.demo.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GetAllChiTietDonDatRequest {
    Date startDate;
    Date endDate;
    Long sanId;
}
