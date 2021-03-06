package com.yarkin.careerguidance.servlets.admin.exam;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.services.ExamService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class EditExamServlet extends HttpServlet {
    private final ExamService examService = new ExamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // load form
        // get form values
        int id = Integer.parseInt(request.getParameter("id"));
        Exam exam = examService.get(id);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("exam", exam);

        String content = PageGenerator.instance().getPage("admin/exam/edit_exam.ftl", parameters);
        request.setAttribute("content", content);
        request.getRequestDispatcher("/admin").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get form values
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Exam exam = new Exam(title, description);

        // add to db
        examService.update(id, exam);
        response.sendRedirect("/admin/zno/all?message=" +
                URLEncoder.encode("Екзамен \"" + title + "\" успішно оновлений", "UTF-8"));
    }
}
