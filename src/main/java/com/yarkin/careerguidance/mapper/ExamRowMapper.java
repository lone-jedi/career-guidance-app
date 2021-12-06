package com.yarkin.careerguidance.mapper;

import com.yarkin.careerguidance.entities.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.text.StringEscapeUtils;

public class ExamRowMapper {
    public Exam mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = StringEscapeUtils.escapeHtml4(resultSet.getString("title"));
        String description = StringEscapeUtils.escapeHtml4(resultSet.getString("description"));
        Exam exam = Exam.builder()
                .id(id)
                .title(title)
                .description(description == null ? "" : description)
                .build();
        return exam;
    }
}
