package com.example.security.py.Entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
@Table(name = "tendency")
public class PyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String morningNight;

    private String focus;

    private String maxFocus;

    private String sleep;

    private String rising;
}
