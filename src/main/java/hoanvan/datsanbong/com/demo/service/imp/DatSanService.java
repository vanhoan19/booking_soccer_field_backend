package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.entity.ChiTietDonDatEntity;
import hoanvan.datsanbong.com.demo.entity.DonDatEntity;
import hoanvan.datsanbong.com.demo.entity.HoaDonEntity;
import hoanvan.datsanbong.com.demo.exception.AppException;
import hoanvan.datsanbong.com.demo.exception.ErrorCode;
import hoanvan.datsanbong.com.demo.repository.ChiTietDonDatRepository;
import hoanvan.datsanbong.com.demo.repository.DonDatRepository;
import hoanvan.datsanbong.com.demo.repository.HoaDonRepository;
import hoanvan.datsanbong.com.demo.service.IDatSanService;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.HoaDonDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DatSanRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.DatSanResponse;
import hoanvan.datsanbong.com.demo.service.mapper.ChiTietDonDatMapper;
import hoanvan.datsanbong.com.demo.service.mapper.DonDatMapper;
import hoanvan.datsanbong.com.demo.service.mapper.HoaDonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatSanService implements IDatSanService {
    private final DonDatRepository donDatRepository;
    private final ChiTietDonDatRepository chiTietDonDatRepository;
    private final HoaDonService hoaDonService;

    private final HoaDonMapper hoaDonMapper;
    private final DonDatMapper donDatMapper;
    private final ChiTietDonDatMapper chiTietDonDatMapper;

    @Override
    public DatSanResponse datSan(DatSanRequest request) {
        // Luu don dat
        DonDatEntity savedDonDat = donDatRepository.save(
                DonDatEntity.builder()
                        .khachHangId(request.getKhachHangId())
                        .sanId(request.getSanId())
                        .soLuong(request.getChitietDonDats().size())
                        .chuaThanhToan(0L)
                        .tongTien(request.getTongTien())
                        .build()
        );

        // Luu chi tiet don dat
        List<ChiTietDonDatDto> savedChiTietDonDats = request.getChitietDonDats().stream().map(chiTietDonDat -> {
            if (chiTietDonDatRepository.existsBySlotIdAndNgayDat(chiTietDonDat.getSlotId(), chiTietDonDat.getNgayDat()))
                throw new AppException(ErrorCode.EXISTED_CHI_TIET_DON_DAT);
            return chiTietDonDatMapper.toDto(
                    chiTietDonDatRepository.save(
                            ChiTietDonDatEntity.builder()
                                    .donDatId(savedDonDat.getId())
                                    .slotId(chiTietDonDat.getSlotId())
                                    .ngayDat(chiTietDonDat.getNgayDat())
                                    .sanId(request.getSanId())
                                    .build()
                    )
            );
        }).toList();

        // Luu hoa don (coc truoc)
        HoaDonDto savedHoaDon = hoaDonService.save(HoaDonEntity.builder()
                        .donDatId(savedDonDat.getId())
                        .sanId(request.getSanId())
                        .tongTien(0L)
                        .daThanhToan(request.getTongTien() / 2)
                .build());

        return DatSanResponse.builder()
                .donDatId(savedDonDat.getId())
                .khachHangId(request.getKhachHangId())
                .hoaDon(savedHoaDon)
                .chiTietDonDats(savedChiTietDonDats)
                .chuaThanhToan(request.getTongTien() / 2)
                .tongTien(savedDonDat.getTongTien())
                .sanId(request.getSanId())
                .soLuong(savedDonDat.getSoLuong())
                .build();
    }
}
