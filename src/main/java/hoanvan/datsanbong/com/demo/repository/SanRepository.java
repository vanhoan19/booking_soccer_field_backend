package hoanvan.datsanbong.com.demo.repository;

import hoanvan.datsanbong.com.demo.entity.SanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanRepository extends JpaRepository<SanEntity, Long> {
    @Query(value = "select * from tbl_san where isnull(parentId)", nativeQuery = true)
    List<SanEntity> getAllParents();

    @Query(value = "select * from tbl_san " +
            "where parentId = :sanId", nativeQuery = true)
    List<SanEntity> getAllChildsBySanId(@Param("sanId") Long sanId);

    Boolean existsByTenSanAndSoDienThoai(String tenSan, String soDienThoai);
}
