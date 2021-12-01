package com.yarkin.careerguidance.servlets;

import com.yarkin.careerguidance.services.ResultService;
import com.yarkin.careerguidance.services.SpecialtyService;
import com.yarkin.careerguidance.services.ZnoService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StartTestServlet extends HttpServlet {
    private final ResultService resultService = new ResultService();
    private final ZnoService znoService = new ZnoService();
    private final SpecialtyService specialtiesService = new SpecialtyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("doGet()");
        Map<String, Object> params = new HashMap<>();

        // get ZNOs from DataBase
        String[] znoNames = znoService.getNames();

        params.put("znos", znoNames);
        String content = PageGenerator.instance().getPage("maintest.ftl", params);

        request.setAttribute("content", content);
        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("doPost()");
        // get chosen zno id
        int[] userZnoId = {
                Integer.parseInt(request.getParameter("first-zno")),
                Integer.parseInt(request.getParameter("second-zno")),
                Integer.parseInt(request.getParameter("third-zno"))
        };

        // get selected test answers
        int questionsCount = 2;
        int[] answerIds = new int[questionsCount];
        for (int i = 1; i <= questionsCount; i++) {
            answerIds[i - 1] = Integer.parseInt(request.getParameter("question:" + i));
        }

        // get test result
        int testId = Integer.parseInt(request.getParameter("test_id"));
        int resultId = resultService.getResultId(testId, answerIds);

        // get specialties corresponding to ZNOs
        int[] specialtiesId = specialtiesService.getByExamsId(userZnoId);

        // sort specialties by user test result
        request.getSession().setAttribute("specialties-ids", specialtiesId);

        response.sendRedirect("/user/get/test/result?test_id=" + resultId);
    }
}
