package int202.sit.simple2.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MultiplicationTableServlet", value = "/MultiplicationTableServlet")
public class MultiplicationTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("number");
        if (param == null || !isDigit(param)) {
            request.setAttribute("message", "Invalid Parameter or No parameter");
        }
        request.getRequestDispatcher("/multiplication_table.jsp").forward(request, response);
    }

    private boolean isDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit((number.charAt(i)))) return false;
        }
        return  true;
    }
}