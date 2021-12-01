package com.yarkin.careerguidance.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String adminLogin = (String) request.getSession().getAttribute("admin_email");

        if(request.getRequestURI().equals("/admin/login")) {
            chain.doFilter(request, response);
            return;
        }

        if(adminLogin == null) {
            response.sendRedirect("/admin/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
