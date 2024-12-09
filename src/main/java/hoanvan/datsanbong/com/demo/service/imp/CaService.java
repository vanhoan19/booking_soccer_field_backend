package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.repository.CaRepository;
import hoanvan.datsanbong.com.demo.service.ICaService;
import hoanvan.datsanbong.com.demo.service.dto.CaDto;
import hoanvan.datsanbong.com.demo.service.mapper.CaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CaService implements ICaService {
    private final CaRepository caRepository;
    private final CaMapper caMapper;

    @Override
    public List<CaDto> findAllCaBySanId(Long sanId) {
        return caRepository.getAllCaBySanId(sanId).stream().map(caMapper::toDto).toList();
    }
}
