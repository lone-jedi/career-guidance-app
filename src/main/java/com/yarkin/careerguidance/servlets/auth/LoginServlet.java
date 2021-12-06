package com.yarkin.careerguidance.servlets.auth;

import com.yarkin.careerguidance.services.UserService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("email", request.getParameter("email"));
        params.put("error_msg", request.getParameter("error_msg"));
        String loginContent = PageGenerator.instance().getPage("login.html", params);

        request.setAttribute("user_email", "гість");
        request.setAttribute("content", loginContent);
        request.getRequestDispatcher("src/templates/page.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(!UserService.isValid(email, password)) {
            response.sendRedirect("/login?email=" + email + "&error_msg=Wrong password or email");
            return;
        }

        request.getSession().setAttribute("user_email", email);
        response.sendRedirect("/user/start/test");
    }
}
