package com.example.ex2_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculator.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double first = Double.parseDouble(req.getParameter("first"));
            double second = Double.parseDouble(req.getParameter("second"));
            String operation = req.getParameter("operation");

            double result = calculate(first, second, operation);
            req.setAttribute("result", result);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    private double calculate(double first, double second, String operation) throws Exception {
        switch (operation) {
            case "addition":
                return first + second;
            case "subtraction":
                return first - second;
            case "multiplication":
                return first * second;
            case "division":
                if (second == 0) {
                    throw new Exception("ko thể chia cho số 0");
                }
                return first / second;
            default:
                throw new Exception("Invalid operation.");
        }
    }
}
