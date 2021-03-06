package com.yarkin.careerguidance.servlets;

import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("content", request.getAttribute("content"));
        parameters.put("user_email", request.getSession().getAttribute("user_email"));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(
                PageGenerator.instance().getPage("templates/page.ftl", parameters));
    }
}
