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

    public void createMedicine(Long userId, String medication) {
        Optional<User> result = userRepository.findById(userId);

        if (result.isEmpty()) {
            return; //new IllegalArgumentException("해당 id의 유저가 없습니다.");
        }
        User user = result.get();
        MedicineMission mission = MedicineMission.builder()
                .medication(medication)
                .user(user)
                .recentTime(LocalDate.now())
                .build();

        medicineMissionRepository.save(mission); // Save the mission to the database
    }

    public void deleteMedicine(Integer medicine_id) {
        // Assuming you have a method to find a MedicineMission by medication name and user
        Optional<MedicineMission> missionResult = medicineMissionRepository.findByMedicineMissionId(medicine_id);

        if (missionResult.isPresent()) {
            MedicineMission mission = missionResult.get();
            medicineMissionRepository.delete(mission.getUser().getMedicineMission()); // Delete the mission from the database
        } else {
            // Optionally, handle the case where the mission doesn't exist
            // e.g., throw new NoSuchElementException("해당 사용자의 약속이 존재하지 않습니다.");
        }
    }
}