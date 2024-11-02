package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unid.team8.service.CareCallPointService;

@RestController
@RequestMapping("/carecall")
@RequiredArgsConstructor
public class getCareCall {

    @GetMapping("/{userId}")
    public String incrementUserPoint(@PathVariable Integer userId) {
        CareCallPointService.incrementUserPoint(userId);
        return "User point incremented successfully";
    }
}
