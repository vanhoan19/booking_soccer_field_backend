package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.service.dto.TaiKhoanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DangKyTaiKhoanRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.DangNhapRequest;

public interface ITaiKhoanService {
    TaiKhoanDto save(DangKyTaiKhoanRequest request);
    TaiKhoanDto login(DangNhapRequest request);
    TaiKhoanDto updatePassword(Long userId, String password);
}
