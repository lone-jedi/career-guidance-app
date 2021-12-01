package com.yarkin.careerguidance.servlets.admin.exam;

import com.yarkin.careerguidance.services.ExamService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteExamsServlet extends HttpServlet {
    private final ExamService examService = new ExamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        examService.delete(id);
        response.sendRedirect("/admin/zno/all?msg=Successfully deleted");
    }
}
