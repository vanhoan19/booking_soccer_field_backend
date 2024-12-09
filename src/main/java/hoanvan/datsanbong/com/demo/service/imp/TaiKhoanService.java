package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.entity.TaiKhoanEntity;
import hoanvan.datsanbong.com.demo.exception.AppException;
import hoanvan.datsanbong.com.demo.exception.ErrorCode;
import hoanvan.datsanbong.com.demo.repository.TaiKhoanRepository;
import hoanvan.datsanbong.com.demo.service.ITaiKhoanService;
import hoanvan.datsanbong.com.demo.service.dto.TaiKhoanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DangKyTaiKhoanRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.DangNhapRequest;
import hoanvan.datsanbong.com.demo.service.mapper.TaiKhoanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaiKhoanService implements ITaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;
    private final TaiKhoanMapper taiKhoanMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public TaiKhoanDto save(DangKyTaiKhoanRequest request) {
        if (taiKhoanRepository.existsBySoDienThoai(request.getSoDienThoai())) throw new AppException(ErrorCode.EXISTED_PHONE_NUMBER);
        TaiKhoanEntity savedTaiKhoan = taiKhoanRepository.save(
                TaiKhoanEntity.builder()
                        .soDienThoai(request.getSoDienThoai())
                        .matKhau(passwordEncoder.encode(request.getMatKhau()))
                        .hoTen(request.getHoTen())
                        .loaiTaiKhoan(request.getLoaiTaiKhoan())
                        .trangThai(request.getTrangThai())
                        .build()
        );
        return taiKhoanMapper.toDto(savedTaiKhoan);
    }

    @Override
    public TaiKhoanDto login(DangNhapRequest request) {
        TaiKhoanEntity taiKhoan = taiKhoanRepository.findBySoDienThoai(request.getSoDienThoai())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED_PHONE_NUMBER));

        if (!passwordEncoder.matches(request.getMatKhau(), taiKhoan.getMatKhau())) throw new AppException(ErrorCode.WRONG_PASSWORD);
        return taiKhoanMapper.toDto(taiKhoan);
    }

    @Override
    public TaiKhoanDto updatePassword(Long userId, String password) {
        TaiKhoanEntity taiKhoan = taiKhoanRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED_PHONE_NUMBER));
        taiKhoan.setMatKhau(passwordEncoder.encode(password));
        return taiKhoanMapper.toDto(taiKhoanRepository.save(taiKhoan));
    }
}
