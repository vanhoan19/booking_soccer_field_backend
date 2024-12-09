package hoanvan.datsanbong.com.demo.controller.imp;

import hoanvan.datsanbong.com.demo.controller.IDatSanController;
import hoanvan.datsanbong.com.demo.service.dto.CaDto;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import hoanvan.datsanbong.com.demo.service.dto.SlotDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DatSanRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.GetAllChiTietDonDatRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.ApiResponse;
import hoanvan.datsanbong.com.demo.service.dto.response.DatSanResponse;
import hoanvan.datsanbong.com.demo.service.imp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DatSanController implements IDatSanController {
    private final ChiTietDonDatService chiTietDonDatService;
    private final CaService caService;
    private final SanService sanService;
    private final DatSanService datSanService;
    private final SlotService slotService;

    @Override
    public ApiResponse<List<ChiTietDonDatDto>> getAllChiTietDonDatIn(GetAllChiTietDonDatRequest request) {
        return ApiResponse.<List<ChiTietDonDatDto>>builder()
                .data(chiTietDonDatService.getAllChiTietDonDatIn(request))
                .build();
    }

    @Override
    public ApiResponse<List<CaDto>> getAllCaBySanId(Long sanId) {
        return ApiResponse.<List<CaDto>>builder()
                .data(caService.findAllCaBySanId(sanId))
                .build();
    }

    @Override
    public ApiResponse<List<SlotDto>> getAllSlotBySanId(Long sanId) {
        return ApiResponse.<List<SlotDto>>builder()
                .data(slotService.getAllByParentId(sanId))
                .build();
    }

    @Override
    public ApiResponse<List<SanDto>> getAllChildSanBySanId(Long sanId) {
        return ApiResponse.<List<SanDto>>builder()
                .data(sanService.findAllChildSanBySanId(sanId))
                .build();
    }

    @Override
    public ApiResponse<DatSanResponse> datSan(DatSanRequest request) {
        return ApiResponse.<DatSanResponse>builder()
                .data(datSanService.datSan(request))
                .build();
    }
}
