package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.entity.ChiTietDonDatEntity;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.request.GetAllChiTietDonDatRequest;

import java.util.List;

public interface IChiTietDonDatService {
    List<ChiTietDonDatDto> getAllChiTietDonDatIn(GetAllChiTietDonDatRequest request);
}
