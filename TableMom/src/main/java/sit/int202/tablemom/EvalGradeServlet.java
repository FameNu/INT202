package sit.int202.tablemom;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EvalGradeServlet", value = "/eval-grade")
public class EvalGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getNumber = request.getParameter("number");
        System.out.println(getNumber);
        if (getNumber == null || !isNumber(getNumber)) {
            request.setAttribute("msg", "Invalid Score");
        }
        else {
            char grade;
            double score = Double.parseDouble(getNumber);
            if (score >= 80) grade = 'A';
            else if (score >= 70) grade = 'B';
            else if (score >= 60) grade = 'C';
            else if (score >= 50) grade = 'D';
            else grade = 'F';
            request.setAttribute("grade", grade);
        }
        request.getRequestDispatcher("/evalgrade.jsp").forward(request, response);
    }

    private boolean isNumber(String number) {
        try {
            Double.parseDouble((number));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}