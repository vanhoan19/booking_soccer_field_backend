package hoanvan.datsanbong.com.demo.controller;

import hoanvan.datsanbong.com.demo.service.dto.TaiKhoanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DangKyTaiKhoanRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.DangNhapRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.UpdatePasswordRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/taikhoan")
public interface ITaiKhoanController {
    @PostMapping(value = "/dang-ky", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse<TaiKhoanDto> createAccount(@Valid DangKyTaiKhoanRequest request);

    @PostMapping(value = "/dang-nhap", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse<TaiKhoanDto> login(@Valid DangNhapRequest request);

    @PostMapping(value = "/update-password")
    ApiResponse<TaiKhoanDto> updatePassword(@Valid @RequestBody UpdatePasswordRequest request);
}
