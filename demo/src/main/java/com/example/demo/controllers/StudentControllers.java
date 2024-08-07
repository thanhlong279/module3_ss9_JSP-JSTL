package com.example.demo.controllers;

import com.example.demo.dto.StudentDTO;
import com.example.demo.models.Classroom;
import com.example.demo.models.Student;
import com.example.demo.models.services.IClassroomService;
import com.example.demo.models.services.IStudentService;
import com.example.demo.models.services.impl.ClassroomService;
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

    private static IClassroomService classroomService = new ClassroomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                List<Classroom> classrooms = classroomService.findAll();
                req.setAttribute("classrooms", classrooms);
                req.getRequestDispatcher("/student/create.jsp").forward(req, resp);
                break;
            case "edit":
                editShowForm(req, resp);
                break;
            default:
                List<StudentDTO> students = studentService.findAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
        }

    }

    private void editShowForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Student student = studentService.findById(id);
        List<Classroom> editClassrooms = classroomService.findAll();
        req.setAttribute("student", student);
        req.setAttribute("classrooms", editClassrooms);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
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
                break;
        case "search":
            searchByName(req, resp);
            break;
        }
    }

//private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String search = req.getParameter("search");
//    List<Student> students = studentService.searchByName(search);
//    req.setAttribute("students", students);
//    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
//}



    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Boolean isDelete = studentService.deleteByID(id);
        if (isDelete) {
            resp.sendRedirect("/student");
        } else {
            req.setAttribute("message", "Xóa không thành công");
            List<StudentDTO> students = studentService.findAll();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
        }
    }


    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Float points = Float.parseFloat(req.getParameter("point"));
        Long id_class = Long.parseLong(req.getParameter("classroom"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("/student/error-404.jsp");
        } else {
            student.setName(name);
            student.setAddress(address);
            student.setPoint(points);
            student.setId_class(id_class);
            studentService.update(student, id);
            req.setAttribute("student", student);
            req.setAttribute("message", "Thông tin khách hàng đã được cập nhật");
            dispatcher = req.getRequestDispatcher("student/edit.jsp");
        }
        dispatcher.forward(req, resp);
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Float points = Float.parseFloat(req.getParameter("point"));
        Long id_class = Long.parseLong(req.getParameter("classroom"));
        Student student = new Student(name, address, points, id_class);
        studentService.save(student);
        resp.sendRedirect("/student");
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        List<StudentDTO> studentSearch = studentService.findByName(search);
        req.setAttribute("students", studentSearch);
        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
    }
}
