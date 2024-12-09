package hoanvan.datsanbong.com.demo.repository;

import hoanvan.datsanbong.com.demo.entity.CaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaRepository extends JpaRepository<CaEntity, Long> {
    @Query(value = "select * from tbl_ca where sanId = :sanId", nativeQuery = true)
    List<CaEntity> getAllCaBySanId(@Param("sanId") Long sanId);
}
