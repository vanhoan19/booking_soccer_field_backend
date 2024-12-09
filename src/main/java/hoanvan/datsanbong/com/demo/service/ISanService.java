package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.TaoSanRequest;

import java.util.List;

public interface ISanService {
    List<SanDto> findAllSan();
    SanDto getDetailSan(Long sanId);
    List<SanDto> findAllChildSanBySanId(Long sanId);
    SanDto save(TaoSanRequest request);
}
