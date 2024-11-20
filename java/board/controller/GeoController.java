package board.controller;

import board.DTO.GeoDTO;
import board.service.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // JSON 응답을 반환하기 위해 사용
@RequiredArgsConstructor
@RequestMapping("/geo")
public class GeoController {

    private final GeoService geoService;

    /**
     * 위도와 경도를 받아 근처의 데이터를 조회하는 API
     *
     * @param latitude  위도
     * @param longitude 경도
     * @return 근처 위치의 GeoDTO 리스트
     */
    @GetMapping("/location")
    public List<GeoDTO> getNearestLocations(
            @RequestParam double latitude,
            @RequestParam double longitude) {

        // 매개변수 검증
        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Invalid latitude or longitude values.");
        }

        // 서비스 호출 및 데이터 반환
        return geoService.findNearest(latitude, longitude);
    }
}
    /**
     * 테스트 API - 단순 텍스트 반환
     * @return 샘플 텍스트
     */
@Controller // JSON 응답을 반환하기 위해 사용
@RequiredArgsConstructor
@RequestMapping("/geo")
class GeohomeController {
    @GetMapping("/test")
    public String testAPI() {
        return "sample";
    }
}

