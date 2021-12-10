package com.yarkin.careerguidance.entities;

import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Cathedra {
    private long id;
    private String title;
    private String description;
    private List<Exam> exams;
    private List<Specialty> specialties;

    public Cathedra(String title, String description) {
        this(title, description, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
    }

    public Cathedra(String title, String description, List<Exam> exams, List<Specialty> specialties) {
        this(0, title, description, exams, specialties);
    }
}
