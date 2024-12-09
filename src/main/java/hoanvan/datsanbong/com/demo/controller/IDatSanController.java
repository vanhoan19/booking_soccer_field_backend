package hoanvan.datsanbong.com.demo.controller;

import hoanvan.datsanbong.com.demo.service.dto.CaDto;
import hoanvan.datsanbong.com.demo.service.dto.ChiTietDonDatDto;
import hoanvan.datsanbong.com.demo.service.dto.SanDto;
import hoanvan.datsanbong.com.demo.service.dto.SlotDto;
import hoanvan.datsanbong.com.demo.service.dto.request.DatSanRequest;
import hoanvan.datsanbong.com.demo.service.dto.request.GetAllChiTietDonDatRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.ApiResponse;
import hoanvan.datsanbong.com.demo.service.dto.response.DatSanResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dat-san")
public interface IDatSanController {
    @PostMapping(value = "/get-all-chi-tiet-dondat", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse<List<ChiTietDonDatDto>> getAllChiTietDonDatIn(
            @Valid GetAllChiTietDonDatRequest request
    );

    @PostMapping(value = "/get-all-ca/{sanId}")
    ApiResponse<List<CaDto>> getAllCaBySanId(@PathVariable("sanId") Long sanId);

    @PostMapping(value = "/get-all-slot/{sanId}")
    ApiResponse<List<SlotDto>> getAllSlotBySanId(@PathVariable("sanId") Long sanId);

    @PostMapping(value = "/get-all-child-san/{sanId}")
    ApiResponse<List<SanDto>> getAllChildSanBySanId(@PathVariable("sanId") Long sanId);

    @PostMapping(value = "/dat-coc")
    ApiResponse<DatSanResponse> datSan(@Valid @RequestBody DatSanRequest request);
}
