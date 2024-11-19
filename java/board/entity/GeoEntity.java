package board.entity;

import board.DTO.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "geo_table")
public class GeoEntity {
    @Id// pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    private Long Id;

    @Column(length = 30, nullable = false)// 크기 20 not null
    private String district;

    @Column(nullable = false)
    private String location_type;

    @Column(nullable = false)
    private String trash_type;

    @Column(nullable = false) // 크기 255 null 가능
    private String address;

    @Column
    private double latitude;;

    @Column
    private double longitude;;

//    public static GeoEntity toSaveEntity(BoardDTO boardDTO) {
//        GeoEntity boardEntity = new GeoEntity();
//        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
//        boardEntity.setBoardPass(boardDTO.getBoardPass());
//        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
//        boardEntity.setBoardContents(boardDTO.getBoardContents());
//        boardEntity.setBoardHits(0);
////        boardEntity.setFileAttached(0); // 파일 없음.
//        return boardEntity;
//    }
}
