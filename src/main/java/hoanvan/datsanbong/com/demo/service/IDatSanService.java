package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.service.dto.request.DatSanRequest;
import hoanvan.datsanbong.com.demo.service.dto.response.DatSanResponse;

public interface IDatSanService {
    DatSanResponse datSan(DatSanRequest request);
}
