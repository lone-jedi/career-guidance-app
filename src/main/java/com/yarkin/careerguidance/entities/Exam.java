package com.yarkin.careerguidance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Exam {
    private long id;
    private String title;
    private String description;

    public Exam(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
