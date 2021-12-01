package com.yarkin.careerguidance.servlets.admin.exam;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.services.ExamService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShowAllExamsServlet extends HttpServlet {
    private final ExamService examService = new ExamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exam[] exams = examService.getAll();
        String message = request.getParameter("msg") == null ? ""
                : request.getParameter("msg");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("exams", exams);
        parameters.put("message", message);
        String content = PageGenerator.instance().getPage("admin/exam/show_exams.ftl", parameters);
        request.setAttribute("content", content);
        request.getRequestDispatcher("/admin").forward(request, response);
    }
}
