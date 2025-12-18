package com.example.security.schedule.controller;

import com.example.security.schedule.dto.ScheduleDTO;
import com.example.security.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    ScheduleService scheduleService;

    @PostMapping("/schedule/add")
    public ResponseEntity<?> ScheduleAdd(@RequestBody ScheduleDTO dto) {
        scheduleService.AddSchedule(dto);
        return ResponseEntity.ok().build();
    }

    //@GetMapping("/")

}
