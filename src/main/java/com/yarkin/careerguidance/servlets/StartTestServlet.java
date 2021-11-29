package com.yarkin.careerguidance.servlets;

import com.yarkin.careerguidance.services.ZnoService;
import com.yarkin.careerguidance.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StartTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> params = new HashMap<>();

        // get ZNOs from DataBase
        ZnoService znoService = new ZnoService();
        String[] znoNames = znoService.getNames();

        params.put("znos", znoNames);
        String content = PageGenerator.instance().getPage("maintest.html", params);

        request.setAttribute("content", content);
        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get chosen zno id
        int[] userZnoId = {
                Integer.parseInt(request.getParameter("first-zno")),
                Integer.parseInt(request.getParameter("second-zno")),
                Integer.parseInt(request.getParameter("third-zno"))
        };

        // get selected test answers
        int questionsCount = 2;
        for (int i = 1; i <= questionsCount; i++) {
            System.out.println(request.getParameter("question:" + i));
        }

        // get test result

        // get specialties corresponding to ZNOs

        // sort specialties by user test result

    }
}
