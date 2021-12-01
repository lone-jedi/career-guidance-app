package com.yarkin.careerguidance.servlets.admin.auth;

import com.yarkin.careerguidance.services.UserService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> params = new HashMap<>();
        params.put("email", request.getParameter("email"));
        params.put("error_msg", request.getParameter("error_msg"));
        String loginContent = PageGenerator.instance().getPage("admin/login.ftl", params);
        response.getWriter().print(loginContent);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // TODO make ability to add admin users
        if(!email.equals("admin@mail.com") || !password.equals("root")) {
            response.sendRedirect("/admin/login?email=" + email + "&error_msg=Wrong password or email");
            return;
        }

        request.getSession().setAttribute("admin_email", email);
        response.sendRedirect("/admin");
    }
}
