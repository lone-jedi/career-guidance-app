package com.yarkin.careerguidance.servlets.admin.cathedra;

import com.yarkin.careerguidance.dao.SpecialtyDao;
import com.yarkin.careerguidance.entities.Cathedra;
import com.yarkin.careerguidance.entities.Exam;
import com.yarkin.careerguidance.entities.Specialty;
import com.yarkin.careerguidance.services.CathedraService;
import com.yarkin.careerguidance.services.ExamService;
import com.yarkin.careerguidance.services.SpecialtyService;
import com.yarkin.careerguidance.utils.templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCathedraServlet extends HttpServlet {
    CathedraService cathedraService = new CathedraService();
    ExamService examService = new ExamService();
    SpecialtyService specialtyService = new SpecialtyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        List<Specialty> specialties = specialtyService.getAll();
        List<Exam> exams = examService.getAll();
        Cathedra cathedra = new Cathedra(title, description, exams, specialties);

        String errorMessage = request.getParameter("error_message");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("errorMessage", errorMessage);
        parameters.put("cathedra", cathedra);

        String content = PageGenerator.instance().getPage("admin/cathedra/add_cathedra.ftl", parameters);

        request.setAttribute("content", content);
        request.getRequestDispatcher("/admin").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // add to db
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        long[] exams = Arrays.stream(request.getParameterValues("exams"))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] specialties = Arrays.stream(request.getParameterValues("specialties"))
                .mapToLong(Long::parseLong)
                .toArray();

        Cathedra cathedra = new Cathedra(title, description);
        cathedraService.add(cathedra, exams, specialties);
        response.sendRedirect(response.encodeURL("/admin/cathedra/all?message=" +
                URLEncoder.encode("Кафедра \"" + title + "\" успішно додана", "UTF-8")));
    }
}
