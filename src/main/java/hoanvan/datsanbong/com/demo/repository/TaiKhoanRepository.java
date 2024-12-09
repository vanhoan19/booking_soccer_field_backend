package hoanvan.datsanbong.com.demo.repository;

import hoanvan.datsanbong.com.demo.entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, Long> {
    Boolean existsBySoDienThoai(String soDienThoai);

    Optional<TaiKhoanEntity> findBySoDienThoai(String soDienThoai);
}
