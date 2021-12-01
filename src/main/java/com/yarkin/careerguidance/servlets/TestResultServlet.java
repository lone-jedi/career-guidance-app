package com.yarkin.careerguidance.servlets;

import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("doGet()");
        Map<String, Object> params = new HashMap<>();
        params.put("test_id", request.getParameter("test_id"));
        String content = PageGenerator.instance().getPage("test_result.html", params);

        request.setAttribute("content", content);
        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
