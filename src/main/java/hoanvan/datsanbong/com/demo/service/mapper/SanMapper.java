package hoanvan.datsanbong.com.demo.service.mapper;

import hoanvan.datsanbong.com.demo.entity.SanEntity;
import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultConfigMapper.class)
public interface SanMapper extends EntityMapper<SanDto, SanEntity> {
}
