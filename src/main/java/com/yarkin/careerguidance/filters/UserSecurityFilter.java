package com.yarkin.careerguidance.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String userEmail = (String) request.getSession().getAttribute("user_email");
        System.out.println("doFilter():" + userEmail);

        if(request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (userEmail == null) {
            response.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        // Filter.super.destroy();
    }
}
