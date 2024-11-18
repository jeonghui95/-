package board.repository;

import board.entity.BoardEntity;
import board.entity.GeoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeoRepository extends JpaRepository<GeoEntity, Long> {
    // update board_table set board_hits=board_hits+1 where id=?
//    @Modifying
//    @Query(value = "update GeoEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
//    void updateHits(@Param("id") Long id);
}
