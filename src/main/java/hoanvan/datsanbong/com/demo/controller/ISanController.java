package hoanvan.datsanbong.com.demo.controller;

import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.TaoSanRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/san")
public interface ISanController {
    @PostMapping("/get-sans")
    ApiResponse<List<SanDto>> getSans();

    @PostMapping("/detail/{sanId}")
    ApiResponse<SanDto> getDetail(@PathVariable("sanId") Long sanId);

    @PostMapping("/get-childs/{sanId}")
    ApiResponse<List<SanDto>> getChildSans(@PathVariable("sanId") Long sanId);

    @PostMapping(value = "/tao-san", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse<SanDto> createParentSan(@Valid TaoSanRequest request);
}
