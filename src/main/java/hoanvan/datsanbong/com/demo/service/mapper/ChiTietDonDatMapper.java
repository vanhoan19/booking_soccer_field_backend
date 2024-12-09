package hoanvan.datsanbong.com.demo.service.mapper;

import hoanvan.datsanbong.com.demo.entity.ChiTietDonDatEntity;
import hoanvan.datsanbong.com.demo.entity.TaiKhoanEntity;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.TaiKhoanDto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultConfigMapper.class)
public interface ChiTietDonDatMapper extends EntityMapper<ChiTietDonDatDto, ChiTietDonDatEntity>{
}
