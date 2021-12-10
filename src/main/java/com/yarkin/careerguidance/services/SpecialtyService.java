package com.yarkin.careerguidance.services;

import com.yarkin.careerguidance.dao.SpecialtyDao;
import com.yarkin.careerguidance.entities.Specialty;

import java.util.List;

public class SpecialtyService {
    private static final SpecialtyDao SPECIALTY_DAO = new SpecialtyDao();

    public int[] getByExamsId(int[] userZnoId) {
        return new int[0];
    }

    public List<Specialty> getAll() {
        return SPECIALTY_DAO.getAll();
    }

    public void add(Specialty specialty) {
        SPECIALTY_DAO.add(specialty);
    }

    public Specialty get(int id) {
        return SPECIALTY_DAO.get(id);
    }

    public void update(int id, Specialty specialty) {
        SPECIALTY_DAO.update(id, specialty);
    }

    public void delete(int id) {
        SPECIALTY_DAO.delete(id);
    }
}
