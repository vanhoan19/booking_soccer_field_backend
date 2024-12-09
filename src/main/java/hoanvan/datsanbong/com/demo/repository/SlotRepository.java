package hoanvan.datsanbong.com.demo.repository;

import hoanvan.datsanbong.com.demo.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlotRepository extends JpaRepository<SlotEntity, Long> {
    @Query(value = "select * from tbl_slot where parentSanId = :parentId", nativeQuery = true)
    List<SlotEntity> findAllByParentId(Long parentId);
}
