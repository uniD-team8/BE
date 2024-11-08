package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unid.team8.entity.Gift;
import unid.team8.service.GiftService;
import unid.team8.dto.GiftResponseDto;
import unid.team8.dto.UserRequestDto;
import unid.team8.entity.User;
import java.util.List;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RequestMapping("/product")
@RequiredArgsConstructor
public class GiftController {

    private final GiftService giftService;

    // GET 요청을 처리하는 엔드포인트, 모든 선물 목록 조회
    @GetMapping("/list")
    public List<Gift> getAllGifts() {
        return giftService.getAllGifts();
    }

    @PostMapping("/{productid}")
    public GiftResponseDto getProductInfo(
            @PathVariable("productid") Long productId,
            @RequestBody UserRequestDto request) {
        return giftService.getGiftWithUserPoints(productId, request.getUserId());
    }

    // 특정 gift_id로 User의 giftId 필드를 업데이트하는 엔드포인트
    @PutMapping("/{gift_id}/user/{user_id}")
    public User updateUserGift(
            @PathVariable("gift_id") Long giftId,
            @PathVariable("user_id") Long userId) {
        return giftService.updateUserGift(giftId, userId);
    }

    @GetMapping("/favorite/{userId}")
    public ResponseEntity<GiftResponseDto> getFavoriteGifts(@PathVariable Long userId) {
        GiftResponseDto dto=giftService.getFavoriteGift(userId);
        return ResponseEntity.ok().body(dto);
    }
}
