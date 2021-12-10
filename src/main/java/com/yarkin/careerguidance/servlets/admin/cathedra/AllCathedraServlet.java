package com.yarkin.careerguidance.servlets.admin.cathedra;

import com.yarkin.careerguidance.entities.Cathedra;
import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.services.CathedraService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllCathedraServlet extends HttpServlet {
    CathedraService cathedraService = new CathedraService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cathedra> cathedras = cathedraService.getAll();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cathedras", cathedras);
        parameters.put("message", request.getParameter("message"));

        String content = PageGenerator.instance().getPage("admin/cathedra/show_cathedra.ftl", parameters);
        request.setAttribute("content", content);
        request.getRequestDispatcher("/admin").forward(request, response);
    }
}
