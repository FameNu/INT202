package int202.sit.simple2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "FavoriteSubjectServlet", value = "/FavoriteSubjectServlet")
public class FavoriteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPeocess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPeocess(request, response);
    }

    protected void doPeocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String[] favSubject = request.getParameterValues("favorite_subject");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your Favorite Subject:</h1>");
        out.println("Student ID: " + id + "<br>");
        out.println("Student Name: " + name + "<br>");
        out.println("Favorite Subject: " + "<br>");
        for (String subject:favSubject){
            out.println("\t- " + subject + "<br>");
        }
        Map<String, String[]> params = request.getParameterMap();
        out.println("<hr>");
        out.println("Request Parameters from Map: <br>");
        out.println("Student ID: " + params.get("id")[0] + "<br>");
        out.println("Student Name: " + params.get("name")[0] + "<br>");
        out.println("Favorite Subject: " + "<br>");
        for (String subject:params.get("favorite_subject")){
            out.println("&nbsp;&nbsp;- " + subject + "<br>");
        }
        out.println("</body></html>");
    }
}