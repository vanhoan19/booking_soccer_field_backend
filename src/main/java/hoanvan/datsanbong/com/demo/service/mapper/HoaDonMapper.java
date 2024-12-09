package hoanvan.datsanbong.com.demo.service.mapper;

import hoanvan.datsanbong.com.demo.entity.ChiTietDonDatEntity;
import hoanvan.datsanbong.com.demo.entity.HoaDonEntity;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.HoaDonDto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultConfigMapper.class)
public interface HoaDonMapper extends EntityMapper<HoaDonDto, HoaDonEntity>{
}
