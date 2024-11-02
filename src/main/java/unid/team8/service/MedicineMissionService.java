package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.dto.MedicineRequestDto;
import unid.team8.entity.MedicineMission;
import unid.team8.entity.User;
import unid.team8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MedicineMissionService {

    private final UserRepository userRepository;
    /*
    public void createMedicine(MedicineRequestDto medicineRequestDto) {
        User user=userRepository.findById(medicineRequestDto.getUserId()).orElse(()-> new IllegalArgumentException("해당 id의 유저가 없습니다."));
        MedicineMission mission=MedicineMission.builder()
                .medication(medicineRequestDto.getMedication())
                .user()

    }
    */

}
