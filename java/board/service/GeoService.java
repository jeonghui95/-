package board.service;

import board.DTO.GeoDTO;
import board.entity.GeoEntity;
import board.repository.GeoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DTO --> Entity(Entity class)
//Entity --> DTO(DTO class)


@Service
@RequiredArgsConstructor
public class GeoService {
    private final GeoRepository geoRepository;

//    public void save(GeoDTO geoDTO) {
//        GeoEntity boardEntity = GeoEntity.toSaveEntity(boardDTO);
//        geoRepository.save(boardEntity);
//    }
    @Transactional
    public List<GeoDTO> findAll() {
        List<GeoEntity> geoEntityList = geoRepository.findAll();
        List<GeoDTO> geoDTOList = new ArrayList<>();
        for (GeoEntity geoEntity: geoEntityList) {
            geoDTOList.add(GeoDTO.toGeoDTO(geoEntity));
        }
        return geoDTOList;
    }

//    @Transactional
//    public void updateHits(Long id) {
//        geoRepository.updateHits(id);
//    }

//    @Transactional
//    public BoardDTO findById(Long id) {
//        Optional<BoardEntity> optionalBoardEntity = geoRepository.findById(id);
//        if (optionalBoardEntity.isPresent()) {
//            BoardEntity boardEntity = optionalBoardEntity.get();
//            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
//            System.out.println(boardDTO);
//            System.out.println(3);
//            return boardDTO;
//        } else {
//            System.out.println(3);
//            System.out.println(3);
//            System.out.println(3);
//            return null;
        }


//    }

//    }

