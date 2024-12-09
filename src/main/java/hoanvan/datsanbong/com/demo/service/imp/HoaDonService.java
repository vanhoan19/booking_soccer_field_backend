package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.entity.DonDatEntity;
import hoanvan.datsanbong.com.demo.entity.HoaDonEntity;
import hoanvan.datsanbong.com.demo.exception.AppException;
import hoanvan.datsanbong.com.demo.exception.ErrorCode;
import hoanvan.datsanbong.com.demo.repository.DonDatRepository;
import hoanvan.datsanbong.com.demo.repository.HoaDonRepository;
import hoanvan.datsanbong.com.demo.service.IHoaDonService;
import hoanvan.datsanbong.com.demo.service.dto.HoaDonDto;
import hoanvan.datsanbong.com.demo.service.mapper.HoaDonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HoaDonService implements IHoaDonService {
    private final HoaDonRepository hoaDonRepository;
    private final DonDatRepository donDatRepository;
    private final HoaDonMapper hoaDonMapper;

    @Override
    public HoaDonDto save(HoaDonEntity hoaDonEntity) {
        HoaDonEntity savedHoaDon = hoaDonRepository.save(hoaDonEntity);
        DonDatEntity donDat = donDatRepository.findById(savedHoaDon.getDonDatId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_DON_DAT));
        donDat.setTongTien(donDat.getTongTien() + savedHoaDon.getTongTien());
        donDat.setChuaThanhToan(donDat.getChuaThanhToan() - (savedHoaDon.getDaThanhToan() - savedHoaDon.getTongTien()));
        donDatRepository.save(donDat);

        return hoaDonMapper.toDto(savedHoaDon);
    }
}
