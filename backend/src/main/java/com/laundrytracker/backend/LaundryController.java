package com.laundrytracker.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LaundryController {

    private final LaundryService laundryService;

    public LaundryController(LaundryService laundryService) {
        this.laundryService = laundryService;
    }

    @GetMapping("/status")
    public List<MachineStatus> getStatus() {
        return laundryService.getStatus();
    }

    @PostMapping("/use")
    public void useMachine(@RequestBody Map<String, String> request) {
        laundryService.useMachine(
                request.get("machine"),
                request.get("name")
        );
    }

    @PostMapping("/release")
    public void releaseMachine(@RequestBody Map<String, String> request) {
        laundryService.releaseMachine(request.get("machine"));
    }
}