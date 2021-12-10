package com.yarkin.careerguidance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Specialty {
    private int id;
    private String title;
    private String description;

    public Specialty(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
