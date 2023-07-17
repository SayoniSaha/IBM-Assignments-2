package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;

public class MyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<String, String> coursePriceMap = new HashMap<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processesRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processesRequest(request, response);
    }

    protected void processesRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String course = null;
        String price = null;
        List<String> errors = new ArrayList<String>();

        course = request.getParameter("course");

        ServletContext servletContext = getServletContext();
        List<String> coursesList = (List<String>) servletContext.getAttribute("coursesList");
        if (coursesList == null) {
            coursesList = new ArrayList<>();
        }

        String courseListParam = getServletConfig().getInitParameter("course");
        if (courseListParam != null && !courseListParam.isEmpty()) {
            List<String> courseList = Arrays.asList(courseListParam.split(","));
            coursesList.addAll(courseList);
        }

        coursesList.add(course);
        servletContext.setAttribute("coursesList", coursesList);

        price = request.getParameter("price");
        if (price == null || price.isEmpty() || !price.matches("\\d{1,3}")) {
            errors.add("Select valid price");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("ERROR", errors);
            RequestDispatcher view = request.getRequestDispatcher("add_course.view");
            view.forward(request, response);
        } else {
            coursePriceMap.put(course, price);
            request.setAttribute("course", new Course(course, price));
            request.setAttribute("coursePriceMap", coursePriceMap);
            RequestDispatcher view = request.getRequestDispatcher("success.view");
            view.forward(request, response);
        }
    }

    public static Map<String, String> getCoursePriceMap() {
        return coursePriceMap;
    }
}
