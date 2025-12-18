package com.example.security.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleDTO {
    private String nickname;

    private LocalDate date;

    private String time;

    private int mood;

    private String title;

    private int time_taken;
}
