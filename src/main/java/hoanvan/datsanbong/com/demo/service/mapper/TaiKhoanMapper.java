package hoanvan.datsanbong.com.demo.service.mapper;

import hoanvan.datsanbong.com.demo.entity.TaiKhoanEntity;
import hoanvan.datsanbong.com.demo.service.dto.TaiKhoanDto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultConfigMapper.class)
public interface TaiKhoanMapper extends EntityMapper<TaiKhoanDto, TaiKhoanEntity>{
}
