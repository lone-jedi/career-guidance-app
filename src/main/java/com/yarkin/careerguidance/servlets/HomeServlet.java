package com.yarkin.careerguidance.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log("doGet()");

        if(request.getAttribute("content") == null) {
            request.setAttribute("content", "Вітаємо!");
        }

        String userEmail = (String) request.getSession().getAttribute("user_email");
        request.setAttribute("user_email", userEmail);

        request.getRequestDispatcher("/src/templates/page.jsp").forward(request, response);
    }
}
