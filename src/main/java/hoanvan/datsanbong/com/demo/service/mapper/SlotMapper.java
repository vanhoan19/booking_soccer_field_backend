package hoanvan.datsanbong.com.demo.service.mapper;

import hoanvan.datsanbong.com.demo.entity.CaEntity;
import hoanvan.datsanbong.com.demo.entity.SlotEntity;
import hoanvan.datsanbong.com.demo.service.dto.CaDto;
import hoanvan.datsanbong.com.demo.service.dto.SlotDto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultConfigMapper.class)
public interface SlotMapper extends EntityMapper<SlotDto, SlotEntity> {
}
