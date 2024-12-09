package hoanvan.datsanbong.com.demo.controller.imp;

import hoanvan.datsanbong.com.demo.controller.ISanController;
import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import hoanvan.datsanbong.com.demo.service.dto.request.TaoSanRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.ApiResponse;
import hoanvan.datsanbong.com.demo.service.imp.SanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SanController implements ISanController {
    private final SanService sanService;

    @Override
    public ApiResponse<List<SanDto>> getSans() {
        return ApiResponse.<List<SanDto>>builder()
                .data(sanService.findAllSan())
                .build();
    }

    @Override
    public ApiResponse<SanDto> getDetail(Long sanId) {
        return ApiResponse.<SanDto>builder()
                .data(sanService.getDetailSan(sanId))
                .build();
    }

    @Override
    public ApiResponse<List<SanDto>> getChildSans(Long sanId) {
        return ApiResponse.<List<SanDto>>builder()
                .data(sanService.findAllChildSanBySanId(sanId))
                .build();
    }

    @Override
    public ApiResponse<SanDto> createParentSan(TaoSanRequest request) {
        return ApiResponse.<SanDto>builder()
                .data(sanService.save(request))
                .build();
    }
}
