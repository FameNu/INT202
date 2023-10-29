package int202.sit.simple2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EvalGradeServlet", value = "/EvalGradeServlet")
public class EvalGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String score = request.getParameter("score");
        int scoreValue = Integer.valueOf(score);
        String grade = "";
        if (scoreValue >= 80) {
            grade = "A";
        } else if (scoreValue >= 70) {
            grade = "B";
        } else if (scoreValue >= 60) {
            grade = "C";
        } else {
            grade = "F";
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your Grade:</h1>");
        out.println("Score: " + score + "<br>");
        out.println("Grade: " + grade + "<br>");
        out.println("</body></html>");
    }
}