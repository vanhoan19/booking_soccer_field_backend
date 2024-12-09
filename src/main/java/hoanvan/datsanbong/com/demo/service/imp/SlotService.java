package hoanvan.datsanbong.com.demo.service.imp;

import hoanvan.datsanbong.com.demo.repository.SlotRepository;
import hoanvan.datsanbong.com.demo.service.ISlotService;
import hoanvan.datsanbong.com.demo.service.dto.SlotDto;
import hoanvan.datsanbong.com.demo.service.mapper.SlotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotService implements ISlotService {
    private final SlotRepository findAllByParentId;
    private final SlotMapper slotMapper;

    @Override
    public List<SlotDto> getAllByParentId(Long sanId) {
        return findAllByParentId.findAllByParentId(sanId).stream().map(slotMapper::toDto).toList();
    }
}
