package com.yarkin.careerguidance.services;

import com.yarkin.careerguidance.dao.ExamDao;
import com.yarkin.careerguidance.entities.Exam;

import java.util.List;

public class ExamService {
    private final ExamDao examDao = new ExamDao();

    public List<Exam> getAll() {
        return examDao.getAll();
    }

    public void add(Exam exam) {
        examDao.add(exam);
    }

    public void delete(long id) {
        examDao.delete(id);
    }

//    public String[] getNames() {
//        Exam[] exams = getAll();
//        String[] examTitles = new String[exams.length];
//        for (int i = 0; i < exams.length; i++) {
//            examTitles[i] = exams[i].getTitle();
//        }
//        return examTitles;
//    }

    public void update(long id, Exam exam) {
        examDao.update(id, exam);
    }

    public Exam get(long id) {
        return examDao.get(id);
    }
}
