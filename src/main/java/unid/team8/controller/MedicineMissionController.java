package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unid.team8.dto.MedicineRequestDto;
import unid.team8.service.MedicineMissionService;

@RestController
@RequiredArgsConstructor
public class MedicineMissionController {
    private final MedicineMissionService medicineMissionService;

    @PostMapping("/medicine")
    public ResponseEntity<Void> createMedicine(@RequestBody MedicineRequestDto medicineRequestDto){
        medicineMissionService.createMedicine(medicineRequestDto);
        return ResponseEntity.ok().build();
    }
}
