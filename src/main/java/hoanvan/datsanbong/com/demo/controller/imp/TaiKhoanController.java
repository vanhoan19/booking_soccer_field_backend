package hoanvan.datsanbong.com.demo.controller.imp;

import hoanvan.datsanbong.com.demo.controller.ITaiKhoanController;
import hoanvan.datsanbong.com.demo.service.dto.TaiKhoanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DangKyTaiKhoanRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.DangNhapRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.UpdatePasswordRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.ApiResponse;
import hoanvan.datsanbong.com.demo.service.imp.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaiKhoanController implements ITaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    @Override
    public ApiResponse<TaiKhoanDto> createAccount(DangKyTaiKhoanRequest request) {
        return ApiResponse.<TaiKhoanDto>builder()
                .data(taiKhoanService.save(request))
                .build();
    }

    @Override
    public ApiResponse<TaiKhoanDto> login(DangNhapRequest request) {
        return ApiResponse.<TaiKhoanDto>builder()
                .data(taiKhoanService.login(request))
                .build();
    }

    @Override
    public ApiResponse<TaiKhoanDto> updatePassword(UpdatePasswordRequest request) {
        return ApiResponse.<TaiKhoanDto>builder()
                .data(taiKhoanService.updatePassword(request.getUserId(), request.getPassword()))
                .build();
    }
}
