package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unid.team8.entity.Gift;
import unid.team8.service.GiftService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class GiftController {

    private final GiftService giftService;

    // GET 요청을 처리하는 엔드포인트, 모든 선물 목록 조회
    @GetMapping("/list")
    public List<Gift> getAllGifts() {
        return giftService.getAllGifts();
    }
}
