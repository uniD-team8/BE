package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.entity.Gift;
import unid.team8.entity.User;
import unid.team8.repository.GiftRepository;
import unid.team8.repository.UserRepository;
import unid.team8.dto.GiftResponseDto;
import unid.team8.dto.UserRequestDto;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;
    private final UserRepository userRepository;

    // 모든 선물 목록을 조회하는 메서드
    public List<Gift> getAllGifts() {
        return giftRepository.findAll();
    }

    public GiftResponseDto getGiftWithUserPoints(Integer productId, Long userId) {
        // Gift 조회
        Gift gift = giftRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Gift not found with ID: " + productId));
        
        // User 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        
        // 포인트 비율 계산
        int percentage = (int) ((double) user.getPoint() / gift.getPoints() * 100);

        // 결과 반환
        return new GiftResponseDto(gift.getName(), gift.getPhoto(), percentage);
    }

    // gift_id와 user_id를 받아 User 엔티티의 giftId 필드를 업데이트
    public User updateUserGift(Long giftId, Long userId) {
        // User 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        
        // giftId 필드 업데이트
        user.setGiftId(giftId);
        
        // 변경 사항 저장
        return userRepository.save(user);
    }

    
}
