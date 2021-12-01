package com.yarkin.careerguidance.services;

import com.yarkin.careerguidance.dao.ExamDao;
import com.yarkin.careerguidance.entities.Exam;

import java.util.List;

public class ExamService {
    private final ExamDao examDao = new ExamDao();

    public Exam[] getAll() {
        List<Exam> exams = examDao.getAll();
        return exams.toArray(new Exam[exams.size()]);
    }

    public void add(Exam exam) {
        examDao.add(exam);
    }

    public void delete(int id) {
        examDao.delete(id);
    }

    public String[] getNames() {
        Exam[] exams = getAll();
        String[] examTitles = new String[exams.length];
        for (int i = 0; i < exams.length; i++) {
            examTitles[i] = exams[i].getTitle();
        }
        return examTitles;
    }
}
