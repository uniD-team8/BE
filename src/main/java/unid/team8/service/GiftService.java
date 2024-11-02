package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.entity.Gift;
import unid.team8.repository.GiftRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;

    // 모든 선물 목록을 조회하는 메서드
    public List<Gift> getAllGifts() {
        return giftRepository.findAll();
    }
}
