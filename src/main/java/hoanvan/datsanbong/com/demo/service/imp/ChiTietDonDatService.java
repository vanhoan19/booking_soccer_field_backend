package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.entity.ChiTietDonDatEntity;
import hoanvan.datsanbong.com.demo.entity.DonDatEntity;
import hoanvan.datsanbong.com.demo.repository.ChiTietDonDatRepository;
import hoanvan.datsanbong.com.demo.repository.DonDatRepository;
import hoanvan.datsanbong.com.demo.service.IChiTietDonDatService;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.request.GetAllChiTietDonDatRequest;
import hoanvan.datsanbong.com.demo.service.mapper.ChiTietDonDatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChiTietDonDatService implements IChiTietDonDatService {
    private final ChiTietDonDatRepository chiTietDonDatRepository;
    private final DonDatRepository donDatRepository;
    private final ChiTietDonDatMapper chiTietDonDatMapper;

    @Override
    public List<ChiTietDonDatDto> getAllChiTietDonDatIn(GetAllChiTietDonDatRequest request) {
        return chiTietDonDatRepository.getAllChiTietDonDatIn(request.getSanId(), request.getStartDate(), request.getEndDate()).stream().map(chiTietDonDatMapper::toDto).toList();
    }
}
