package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unid.team8.entity.User;
import unid.team8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CareCallPointService {

    private final UserRepository userRepository;

    // 포인트 증가 메서드
    @Transactional
    public void incrementUserPoint(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        
        // 포인트 증가
        user.setPoint(user.getPoint() + 1);
        
        // 변경 사항 저장 (JPA가 자동으로 처리)
    }
}
