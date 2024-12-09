package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.entity.SanEntity;
import hoanvan.datsanbong.com.demo.exception.AppException;
import hoanvan.datsanbong.com.demo.exception.ErrorCode;
import hoanvan.datsanbong.com.demo.repository.SanRepository;
import hoanvan.datsanbong.com.demo.service.ISanService;
import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.TaoSanRequest;
import hoanvan.datsanbong.com.demo.service.mapper.SanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SanService implements ISanService {
    private final SanRepository sanRepository;
    private final SanMapper sanMapper;
    private final MinioService minioService;

    @Override
    public List<SanDto> findAllSan() {
        return sanRepository.getAllParents().stream().map(sanMapper::toDto).toList();
    }

    @Override
    public SanDto getDetailSan(Long sanId) {
        return sanMapper.toDto(sanRepository.findById(sanId).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_SAN)));
    }

    @Override
    public List<SanDto> findAllChildSanBySanId(Long sanId) {
        return sanRepository.getAllChildsBySanId(sanId).stream().map(sanMapper::toDto).toList();
    }

    @Override
    public SanDto save(TaoSanRequest request) {
        if (sanRepository.existsByTenSanAndSoDienThoai(request.getTenSan(), request.getSoDienThoai()))
            throw new AppException(ErrorCode.INVALID_TAO_SAN);

        List<String> hinhAnhDetails = request.getHinhAnhDetails().stream().map(minioService::uploadFile).toList();
        return sanMapper.toDto(sanRepository.save(SanEntity.builder()
                        .tenSan(request.getTenSan())
                        .description(request.getDescription())
                        .diaChi(request.getDiaChi())
                        .soDienThoai(request.getSoDienThoai())
                        .hinhAnhMain(minioService.uploadFile(request.getHinhAnhMain()))
                        .hinhAnhDetail(String.join("|", hinhAnhDetails))
                        .parentId(request.getParentId())
                        .trangThai(true)
                .build()));
    }
}
