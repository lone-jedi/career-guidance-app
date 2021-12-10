package com.yarkin.careerguidance.mapper;

import com.yarkin.careerguidance.dao.CathedraDao;
import com.yarkin.careerguidance.entities.Cathedra;
import org.apache.commons.text.StringEscapeUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CathedraRowMapper {
    public static final CathedraDao CATHEDRA_DAO = new CathedraDao();

    public Cathedra mapRow(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String title = StringEscapeUtils.escapeHtml4(resultSet.getString("title"));
        String description = StringEscapeUtils.escapeHtml4(resultSet.getString("description"));
        Cathedra cathedra = Cathedra.builder()
                .id(id)
                .title(title)
                .description(description)
                .exams(CATHEDRA_DAO.getExams(id))
                .specialties(CATHEDRA_DAO.getSpecialties(id))
                .build();
        return cathedra;
    }
}
