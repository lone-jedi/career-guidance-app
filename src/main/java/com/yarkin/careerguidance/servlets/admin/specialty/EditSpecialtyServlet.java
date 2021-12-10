package com.yarkin.careerguidance.servlets.admin.specialty;

import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.entities.Specialty;
import com.yarkin.careerguidance.services.SpecialtyService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class EditSpecialtyServlet extends HttpServlet {
    private static final SpecialtyService SPECIALTY_SERVICE = new SpecialtyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Specialty specialty = SPECIALTY_SERVICE.get(id);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("specialty", specialty);

        String content = PageGenerator.instance().getPage("admin/specialty/edit_specialty.ftl",
                parameters);
        request.setAttribute("content", content);
        request.getRequestDispatcher("/admin").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        SPECIALTY_SERVICE.update(id, new Specialty(title, description));

        response.sendRedirect("/admin/specialty/all?message=" +
                URLEncoder.encode("Спеціальність \"" + title + "\" успішно оновлена", "UTF-8"));
    }
}
