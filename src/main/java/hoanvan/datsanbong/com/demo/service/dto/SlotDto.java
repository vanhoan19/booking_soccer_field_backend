package hoanvan.datsanbong.com.demo.service.dto;

import hoanvan.datsanbong.com.demo.entity.enums.DayOfWeek;
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
public class SlotDto {
    Long id;
    Long sanId;
    Long caId;
    DayOfWeek dayOfWeek;
    Long gia;
    Long parentSanId;

}
