package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.entity.HoaDonEntity;
import hoanvan.datsanbong.com.demo.service.dto.HoaDonDto;

public interface IHoaDonService {
    HoaDonDto save(HoaDonEntity hoaDonEntity);
}
