package com.yarkin.careerguidance.servlets.admin.specialty;

import com.yarkin.careerguidance.services.SpecialtyService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

public class DeleteSpecialtyServlet extends HttpServlet {
    private static final SpecialtyService SPECIALTY_SERVICE = new SpecialtyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SPECIALTY_SERVICE.delete(id);
        response.sendRedirect("/admin/specialty/all?message=" +
                URLEncoder.encode("Спеціальність за id='" + id + "' успішно видалена", "UTF-8"));
    }
}
