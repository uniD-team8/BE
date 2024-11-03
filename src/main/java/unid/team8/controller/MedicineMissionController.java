package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unid.team8.dto.MedicineRequestDto;
import unid.team8.service.MedicineMissionService;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RequiredArgsConstructor
public class MedicineMissionController {
    private final MedicineMissionService medicineMissionService;
/*
    @PostMapping("/medicine")
    public ResponseEntity<Void> createMedicine(@RequestParam Long userId, @RequestParam String medication){
        medicineMissionService.createMedicine(userId, medication);
        return ResponseEntity.ok().build();
    }
*/
    @PostMapping("/medicine")
    public ResponseEntity<Void> createMedicine(@RequestBody MedicineRequestDto medicineRequestDto){
        medicineMissionService.createMedicine(medicineRequestDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/medicine/{userId}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long userId) {
        medicineMissionService.deleteMedicine(userId);
        return ResponseEntity.ok().build();
    }
}
