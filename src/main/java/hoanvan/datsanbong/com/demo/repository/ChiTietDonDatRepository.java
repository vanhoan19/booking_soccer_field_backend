package hoanvan.datsanbong.com.demo.repository;

import hoanvan.datsanbong.com.demo.entity.ChiTietDonDatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ChiTietDonDatRepository extends JpaRepository<ChiTietDonDatEntity, Long> {
    @Query(value = "select * " +
            "from tbl_chitietdondat " +
            "where sanId = :sanId and (ngayDat between :startDate and :endDate)", nativeQuery = true)
    List<ChiTietDonDatEntity> getAllChiTietDonDatIn(
            @Param("sanId") Long sanId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    Boolean existsBySlotIdAndNgayDat(Long slotId, Date ngayDat);
}
