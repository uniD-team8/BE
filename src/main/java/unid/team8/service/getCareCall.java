package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unid.team8.service.CareCallPointService;

@RestController
@RequestMapping("/carecall")
@RequiredArgsConstructor
public class getCareCall {

    private final CareCallPointService careCallPointService;

    @GetMapping("/{userId}")
    public String incrementUserPoint(@PathVariable Long userId) {
        careCallPointService.incrementUserPoint(userId);
        return "User point incremented successfully";
    }
}
