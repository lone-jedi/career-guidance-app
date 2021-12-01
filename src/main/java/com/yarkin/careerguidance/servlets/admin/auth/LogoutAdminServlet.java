package com.yarkin.careerguidance.servlets.admin.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/admin/login");
    }
}
