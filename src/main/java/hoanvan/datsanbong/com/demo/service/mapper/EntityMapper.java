package hoanvan.datsanbong.com.demo.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

public interface EntityMapper <D, E> { // D: dto, E: entity
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    E toEntity(D dto);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    D toDto(E entity);
}
