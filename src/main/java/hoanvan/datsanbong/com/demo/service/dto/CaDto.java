package hoanvan.datsanbong.com.demo.service.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaDto {
    Long id;
    LocalTime gioBatDau;
    LocalTime gioKetThuc;
    Long sanId;
}
