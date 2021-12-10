package com.yarkin.careerguidance.services;

import com.yarkin.careerguidance.dao.CathedraDao;
import com.yarkin.careerguidance.entities.Cathedra;

import java.util.List;

public class CathedraService {
    CathedraDao cathedraDao = new CathedraDao();

    public long add(Cathedra cathedra) {
        return add(cathedra, null, null);
    }

    public long add(Cathedra cathedra, long[] examsIds, long[] specialtyIds) {
        long cathedraId = cathedraDao.add(cathedra);
        cathedraDao.addExams(cathedraId, examsIds);
        cathedraDao.addSpecialties(cathedraId, specialtyIds);
        return cathedraId;
    }

    public List<Cathedra> getAll() {
        return cathedraDao.getAll();
    }
}
