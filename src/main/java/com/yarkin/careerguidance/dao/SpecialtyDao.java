package com.yarkin.careerguidance.dao;

import com.yarkin.careerguidance.entities.Specialty;
import com.yarkin.careerguidance.mapper.SpecialtyRowMapper;
import com.yarkin.careerguidance.utils.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyDao {
    private static final Connection CONNNECTION = JdbcConnection.instance();
    private static final SpecialtyRowMapper SPECIALTY_ROW_MAPPER = new SpecialtyRowMapper();

    public static final String SELECT_ALL = "SELECT id, title, description FROM specialty ORDER BY id DESC;";
    public static final String SELECT_BY_ID = "SELECT id, title, description FROM specialty WHERE id=?;";
    public static final String INSERT = "INSERT INTO specialty(title, description) VALUES (?, ?);";
    public static final String UPDATE = "UPDATE specialty SET title=?, description=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM specialty WHERE id=?";

    public List<Specialty> getAll() {
        List<Specialty> result;

        try (ResultSet resultSet = CONNNECTION.prepareStatement(SELECT_ALL).executeQuery();) {
            result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(SPECIALTY_ROW_MAPPER.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get all specialties", e);
        }

        return result;
    }

    public void add(Specialty specialty) {
        try (PreparedStatement preparedStatement = CONNNECTION.prepareStatement(INSERT);) {
            preparedStatement.setString(1, specialty.getTitle());
            preparedStatement.setString(2, specialty.getDescription());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot add specialty '" + specialty.getTitle() + "'", e);
        }
    }

    public Specialty get(int id) {
        Specialty specialty = null;

        try (PreparedStatement preparedStatement = CONNNECTION.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                resultSet.next();
                specialty = SPECIALTY_ROW_MAPPER.mapRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get specialty id=" + id, e);
        }

        return specialty;
    }

    public void update(int id, Specialty specialty) {
        try (PreparedStatement preparedStatement = CONNNECTION.prepareStatement(UPDATE);) {
            preparedStatement.setString(1, specialty.getTitle());
            preparedStatement.setString(2, specialty.getDescription());
            preparedStatement.setLong(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot update specialty id=" + id, e);
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = CONNNECTION.prepareStatement(DELETE);) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot delete specialty id=" + id, e);
        }
    }
}
