package com.example.security.schedule.service;

import com.example.security.schedule.dto.ScheduleDTO;
import com.example.security.schedule.entity.ScheduleEntity;
import com.example.security.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private ScheduleRepository repository;

    public void AddSchedule(ScheduleDTO dto) {
        ScheduleEntity entity = new ScheduleEntity();
        entity.setDate(dto.getDate());
        entity.setTime(dto.getTime());
        entity.setMood(dto.getMood());
        entity.setTitle(dto.getTitle());
        entity.setNickname(dto.getNickname());
        entity.setTime_taken(dto.getTime_taken());

        repository.save(entity);
    }

}
