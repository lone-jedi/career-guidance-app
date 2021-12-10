package com.yarkin.careerguidance.servlets.admin;

import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("content", request.getAttribute("content"));
        parameters.put("message", request.getParameter("message"));

        String output = PageGenerator.instance().getPage("admin/template/page.ftl", parameters);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(output);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
