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

    public List<GeoDTO> findNearest(double latitude, double longitude) {
        List<GeoDTO> geoDTOList = new ArrayList<>();
        List<GeoEntity> geoEntityList = geoRepository.findNearest(latitude, longitude);
        // Entity를 DTO로 변환하여 반환
        for(GeoEntity geoEntity : geoEntityList)
            geoDTOList.add(GeoDTO.toGeoDTO(geoEntity));
            return geoDTOList;
    }
}







//    }

//    }

