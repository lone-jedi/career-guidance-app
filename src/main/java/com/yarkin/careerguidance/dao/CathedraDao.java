package com.yarkin.careerguidance.dao;

import com.yarkin.careerguidance.entities.Cathedra;
import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.entities.Specialty;
import com.yarkin.careerguidance.mapper.CathedraRowMapper;
import com.yarkin.careerguidance.mapper.ExamRowMapper;
import com.yarkin.careerguidance.mapper.SpecialtyRowMapper;
import com.yarkin.careerguidance.utils.jdbc.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CathedraDao {
    private static final ExamRowMapper EXAM_ROW_MAPPER = new ExamRowMapper();
    private static final SpecialtyRowMapper SPECIALTY_ROW_MAPPER = new SpecialtyRowMapper();

    private static final String INSERT = "INSERT INTO cathedra(title, description) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT id, title, description FROM cathedra;";
    private static final String INSERT_SPECIALTY_CATHEDRA = "INSERT INTO specialty_cathedra(cathedra_id, specialty_id) VALUES (?, ?)";
    private static final String INSERT_EXAM_CATHEDRA = "INSERT INTO cathedra_zno(cathedra_id, zno_id) VALUES (?, ?)";
    private static final String LAST_INSERTED_ID = "SELECT last_value FROM cathedra_id_seq";
    private static final String GET_EXAMS = """
            SELECT zno.id, title, description FROM zno
            JOIN cathedra_zno ON (zno.id = cathedra_zno.zno_id)
            WHERE cathedra_zno.cathedra_id=?;
            """;

    private static final CathedraRowMapper CATHEDRA_ROW_MAPPER = new CathedraRowMapper();

    private final Connection connection = JdbcConnection.instance();

    public long getLastId() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LAST_INSERTED_ID);) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                resultSet.next();
                return resultSet.getLong("last_value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get last inserted id from cathedra", e);
        }
    }

    public long add(Cathedra cathedra) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);) {
            preparedStatement.setString(1, cathedra.getTitle());
            preparedStatement.setString(2, cathedra.getDescription());
            preparedStatement.executeUpdate();
            return getLastId();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot add cathedra", e);
        }
    }

    public void addSpecialties(long cathedraId, long[] specialtyIds) {
        for (long specialtyId : specialtyIds) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SPECIALTY_CATHEDRA);) {
                preparedStatement.setLong(1, cathedraId);
                preparedStatement.setLong(2, specialtyId);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot add specialty to cathedra)", e);
            }
        }

    }

    public void addExams(long cathedraId, long[] examIds) {
        for (long examId : examIds) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXAM_CATHEDRA);) {
                preparedStatement.setLong(1, cathedraId);
                preparedStatement.setLong(2, examId);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot add exam to cathedra", e);
            }
        }
    }

    public List<Cathedra> getAll() {
        try (ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();) {
            List<Cathedra> cathedras = new ArrayList<>();
            while (resultSet.next()) {
                cathedras.add(CATHEDRA_ROW_MAPPER.mapRow(resultSet));
            }
            return cathedras;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get all exams", e);
        }
    }

    public List<Exam> getExams(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_EXAMS)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Exam> exams = new ArrayList<>();
                while (resultSet.next()) {
                    exams.add(EXAM_ROW_MAPPER.mapRow(resultSet));
                }
                return exams;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get all exams", e);
        }
    }

    public List<Specialty> getSpecialties(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_EXAMS)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Specialty> specialties = new ArrayList<>();
                while (resultSet.next()) {
                    specialties.add(SPECIALTY_ROW_MAPPER.mapRow(resultSet));
                }
                return specialties;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get all specialties", e);
        }
    }
}
