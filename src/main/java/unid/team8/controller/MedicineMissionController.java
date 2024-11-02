package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unid.team8.dto.MedicineRequestDto;
import unid.team8.service.MedicineMissionService;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class MedicineMissionController {
    private final MedicineMissionService medicineMissionService;

    @PostMapping("/medicine")
    public ResponseEntity<Void> createMedicine(@RequestParam Long userId, @RequestParam String medication){
        medicineMissionService.createMedicine(userId, medication);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/medicine")
    public ResponseEntity<Void> deleteMedicine(@RequestParam Integer medicineId) {
        medicineMissionService.deleteMedicine(medicineId);
        return ResponseEntity.ok().build();
    }
}
