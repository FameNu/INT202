package sit.int202.tablemom;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MultiTableServlet", value = "/multi-table")
public class MultiTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hide", true);
        request.getRequestDispatcher("/multiple_table.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getNumber = request.getParameter("num");
        System.out.printf(getNumber);
        if (!isInteger(getNumber)) {
            request.setAttribute("erMsg", "Invalid Number");
        }
        else {
            request.setAttribute("number", Integer.parseInt(getNumber));
            request.setAttribute("hide", false);
        }
        request.getRequestDispatcher("/multiple_table.jsp").forward(request, response);
    }

    private boolean isInteger(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) return false;
        }
        return true;
    }
}