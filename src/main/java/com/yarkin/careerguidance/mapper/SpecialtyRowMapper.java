package com.yarkin.careerguidance.mapper;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.entities.Specialty;
import org.apache.commons.text.StringEscapeUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialtyRowMapper {
    public Specialty mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = StringEscapeUtils.escapeHtml4(resultSet.getString("title"));
        String description = StringEscapeUtils.escapeHtml4(resultSet.getString("description"));
        Specialty exam = Specialty.builder()
                .id(id)
                .title(title)
                .description(description == null ? "" : description)
                .build();
        return exam;
    }
}
