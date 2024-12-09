package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.service.dto.CaDto;

import java.util.List;

public interface ICaService {
    List<CaDto> findAllCaBySanId(Long sanId);
}
