package com.yarkin.careerguidance.servlets.admin.exam;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.services.ExamService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

public class AddExamServlet extends HttpServlet {
    private final ExamService examService = new ExamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // print form
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // add to db
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Exam exam = new Exam(title, description);
        examService.add(exam);
        response.sendRedirect(response.encodeURL("/admin/zno/all?message=" +
                URLEncoder.encode("Екзамен \"" + title + "\" успішно доданий", "UTF-8")));
    }
}
