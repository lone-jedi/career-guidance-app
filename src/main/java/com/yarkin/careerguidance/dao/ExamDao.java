package com.yarkin.careerguidance.dao;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.mapper.ExamRowMapper;
import com.yarkin.careerguidance.utils.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {
    private static final ExamRowMapper EXAM_ROW_MAPPER = new ExamRowMapper();
    public static final String SELECT_ALL = "SELECT id, title, description FROM zno;";
    public static final String INSERT = "INSERT INTO zno(title, description) VALUES (?, ?);";
    private static final String DELETE = "DELETE FROM zno WHERE id=?";

    private final Connection connection = JdbcConnection.instance();

    public List<Exam> getAll() {
        List<Exam> result = null;

        try {
            ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();

            result = new ArrayList<>();
            while(resultSet.next()) {
                result.add(EXAM_ROW_MAPPER.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void add(Exam exam) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, exam.getTitle());
            preparedStatement.setString(2, exam.getDescription());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
