package hoanvan.datsanbong.com.demo.service.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietDonDatRequest {
    @NotNull
    Long slotId;
    @NotNull
    Date ngayDat;
}
