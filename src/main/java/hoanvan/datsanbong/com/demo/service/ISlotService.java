package hoanvan.datsanbong.com.demo.service;

import hoanvan.datsanbong.com.demo.service.dto.SlotDto;

import java.util.List;

public interface ISlotService {
    List<SlotDto> getAllByParentId(Long sanId);
}
