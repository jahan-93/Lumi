package com.example.security.schedule.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;

    private LocalDate date;

    private String time;

    private int mood;

    private String title;

    private int time_taken;
}
