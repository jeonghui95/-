package board.DTO;

import board.entity.BoardEntity;
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
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;


    public static GeoDTO toBoardDTO(BoardEntity boardEntity) {
        GeoDTO geoDTO = new GeoDTO();
        geoDTO.setId(boardEntity.getId());
        geoDTO.setBoardWriter(boardEntity.getBoardWriter());
        geoDTO.setBoardPass(boardEntity.getBoardPass());
        geoDTO.setBoardTitle(boardEntity.getBoardTitle());
        geoDTO.setBoardContents(boardEntity.getBoardContents());
        geoDTO.setBoardHits(0);
        geoDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        geoDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
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