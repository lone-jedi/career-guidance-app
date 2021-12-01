package com.yarkin.careerguidance.mapper;

import com.yarkin.careerguidance.entities.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamRowMapper {
    public Exam mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");;
        Exam exam = Exam.builder()
                .id(id)
                .title(title)
                .description(description == null ? "" : description)
                .build();
        return exam;
    }
}
