package board.DTO;

import board.entity.BoardEntity;
import board.entity.GeoEntity;
import lombok.*;

import java.time.LocalDateTime;

// DTO(data transfer Object)
@Getter
@Setter
@ToString
@NoArgsConstructor// 기본생성자
@AllArgsConstructor// 모든 필드를 매개변수로 하는 생성자
public class GeoDTO {
      private Long id;
//    private String boardWriter;
//    private String boardPass;
//    private String boardTitle;
//    private String boardContents;
//    private int boardHits;
//    private LocalDateTime boardCreatedTime;
//    private LocalDateTime boardUpdatedTime;
      private String borough;
      private String InstallationLocation;
      private String category;
      private String wasteType;
      private double latitude;
      private double longitude;

    public static GeoDTO toGeoDTO(GeoEntity geoEntity) {
        GeoDTO geoDTO = new GeoDTO();
        geoDTO.setId(geoEntity.getId());
        geoDTO.setBorough(geoEntity.getDistrict());
        geoDTO.setCategory(geoEntity.getLocation_type());
        geoDTO.setInstallationLocation(geoEntity.getTrash_type());
        geoDTO.setWasteType(geoEntity.getAddress());
        geoDTO.setLatitude(geoEntity.getLatitude());
        geoDTO.setLongitude(geoEntity.getLongitude());
//        if (boardEntity.getFileAttached() == 0) {
//            boardDTO.setFileAttached(boardEntity.getFileAttached()); // 0
//        } else {
//            boardDTO.setFileAttached(boardEntity.getFileAttached()); // 1
//            // 파일 이름을 가져가야 함.
//            // orginalFileName, storedFileName : board_file_table(BoardFileEntity)
//            // join
//            // select * from board_table b, board_file_table bf where b.id=bf.board_id
//            // and where b.id=?
//            boardDTO.setOriginalFileName(boardEntity.getBoardFileEntityList().get(0).getOriginalFileName());
//            boardDTO.setStoredFileName(boardEntity.getBoardFileEntityList().get(0).getStoredFileName());
//        }

        return geoDTO;
    }
}