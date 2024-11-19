package board.repository;

import board.entity.BoardEntity;
import board.entity.GeoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoRepository extends JpaRepository<GeoEntity, Long> {

    @Query("SELECT g FROM GeoEntity g WHERE ROUND(g.latitude, 2) = ROUND(:latitude, 2) AND ROUND(g.longitude, 2) = ROUND(:longitude, 2)")// DB에서 고도와 위도가 소수점 둘째짜리 반올림까지 같은 값만 Select
    List<GeoEntity> findNearest(@Param("latitude") double latitude, @Param("longitude") double longitude); // 타입을 Long이 아닌 double로 지정
}

