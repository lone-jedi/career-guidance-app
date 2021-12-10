package com.yarkin.careerguidance.servlets.admin.specialty;

import com.yarkin.careerguidance.services.SpecialtyService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllSpecialtiesServlet extends HttpServlet {
    private static final SpecialtyService SPECIALTY_SERVICE = new SpecialtyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("specialties", SPECIALTY_SERVICE.getAll());
        request.setAttribute("content",
                PageGenerator.instance().getPage("admin/specialty/show_specialties.ftl", parameters));
        request.getRequestDispatcher("/admin").forward(request, response);
    }
}
