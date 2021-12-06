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
    public static final String SELECT_ALL = "SELECT id, title, description FROM zno ORDER BY id DESC;";
    public static final String SELECT_BY_ID = "SELECT id, title, description FROM zno WHERE id=?;";
    public static final String INSERT = "INSERT INTO zno(title, description) VALUES (?, ?);";
    public static final String UPDATE = "UPDATE zno SET title=?, description=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM zno WHERE id=?";

    private final Connection connection = JdbcConnection.instance();

    public List<Exam> getAll() {
        List<Exam> result;

        try (ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();) {
            result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(EXAM_ROW_MAPPER.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get all exams", e);
        }

        return result;
    }

    public void add(Exam exam) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {
            preparedStatement.setString(1, exam.getTitle());
            preparedStatement.setString(2, exam.getDescription());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot add exam", e);
        }
    }

    public void delete(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE);) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot delete exam id=" + id, e);
        }
    }

    public void update(long id, Exam exam) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {
            preparedStatement.setString(1, exam.getTitle());
            preparedStatement.setString(2, exam.getDescription());
            preparedStatement.setLong(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot update exam id=" + exam.getId(), e);
        }
    }

    public Exam get(long id) {
        Exam exam = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                resultSet.next();
                exam = EXAM_ROW_MAPPER.mapRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exam;
    }
}
