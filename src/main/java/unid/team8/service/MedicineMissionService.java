package unid.team8.service;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.dto.MedicineRequestDto;
import unid.team8.entity.MedicineMission;
import unid.team8.entity.User;
import unid.team8.repository.MedicineMissionRepository;
import unid.team8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MedicineMissionService {

    private final UserRepository userRepository;
    private final MedicineMissionRepository medicineMissionRepository;

    public void createMedicine(MedicineRequestDto medicineRequestDto) {
        User user = userRepository.findById(medicineRequestDto.getUserId()).orElseThrow(()->new IllegalArgumentException("해당 id 유저가 없습니다."));

        MedicineMission mission = MedicineMission.builder()
                .medication(medicineRequestDto.getMedication())
                .user(user)
                .recentTime(LocalDate.now())
                .build();

        medicineMissionRepository.save(mission); // Save the mission to the database
    }

    public void deleteMedicine(Long userId) {
        MedicineMission medicine = medicineMissionRepository.findByUser_Id(userId);
        medicineMissionRepository.delete(medicine);
    }
}