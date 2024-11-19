package board.controller;

import board.DTO.GeoDTO;
import board.service.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/geo")
public class GeoController {
    private final GeoService geoService;

//        @GetMapping("/?latitude={latitude}&longitude={longitude}")//API URL 설정 + GET Method
//        public List<GeoDTO> findNearest(@PathVariable double latitude, double longitude) {
//            return geoService.findNearest(latitude,longitude);
//
//        }
        @GetMapping("/location") // API 경로 명확화
        public List<GeoDTO> findNearest(
                @RequestParam double latitude,  // URL 파라미터로 처리
                @RequestParam double longitude) {

            // 매개변수 검증
            if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
                throw new IllegalArgumentException("Invalid latitude or longitude values.");
            }

            // 서비스 호출 및 데이터 반환
            return geoService.findNearest(latitude, longitude);
        }

        @GetMapping("/")
        public  String TestAPI(){
            return "sample";
        }
    }




