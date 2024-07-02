package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.models.services.IStudentService;
import com.example.demo.models.services.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "StudentController", value = "/student")
public class StudentControllers extends HttpServlet {

    private static IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/student/create.jsp").forward(req, resp);
                break;
            case "edit":
                editShowForm(req, resp);
                break;
            default:
                List<Student> students = studentService.findAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
        }

    }

    private void editShowForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("/student/error-404.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("/student/edit.jsp");
        }
        dispatcher.forward(req, resp);
    }


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String action = req.getParameter("action");
    if (action == null) {
        action = "";
    }
    switch (action) {
        case "create":
            createStudent(req, resp);
            break;
        case "delete":
            deleteStudent(req, resp);
            break;
        case "edit":
            editStudent(req, resp);
        case "search":
            searchByName(req, resp);
            break;
    }
}

private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String search = req.getParameter("search");
    List<Student> students = studentService.searchByName(search);
    req.setAttribute("students", students);
    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
}

private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String address = req.getParameter("address");
    Float points = Float.parseFloat(req.getParameter("point"));
    Student student = new Student(name, address, points);
    studentService.save(student);
    resp.sendRedirect("/student");
}

private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Boolean isDelete = studentService.deleteByID(id);
    if (isDelete) {
        resp.sendRedirect("/student");
    } else {
        req.setAttribute("message", "Xóa không thành công");
        List<Student> students = studentService.findAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
    }
}

private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    String name = req.getParameter("name");
    String address = req.getParameter("address");
    Float points = Float.parseFloat(req.getParameter("point"));
    Student student = studentService.findById(id);
    RequestDispatcher dispatcher;
    if (student == null) {
        dispatcher = req.getRequestDispatcher("/student/error-404.jsp");
    } else {
        student.setName(name);
        student.setAddress(address);
        student.setPoint(points);
        studentService.update(id, student);
        req.setAttribute("student", student);
        req.setAttribute("message", "Thông tin khách hàng đã được cập nhật");
        dispatcher = req.getRequestDispatcher("student/edit.jsp");
    }
    dispatcher.forward(req, resp);
}
}
