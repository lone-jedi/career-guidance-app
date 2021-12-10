package com.yarkin.careerguidance.servlets.admin.specialty;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.entities.Specialty;
import com.yarkin.careerguidance.services.SpecialtyService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

public class AddSpecialtyServlet extends HttpServlet {
    private static final SpecialtyService SPECIALTY_SERVICE = new SpecialtyService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Specialty exam = new Specialty(title, description);
        SPECIALTY_SERVICE.add(exam);
        response.sendRedirect("/admin/specialty/all?message="
                + URLEncoder.encode("Спеціальність \"" + title + "\" успішно додана!", "UTF-8"));
    }
}
