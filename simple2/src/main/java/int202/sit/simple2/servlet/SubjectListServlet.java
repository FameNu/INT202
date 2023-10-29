package int202.sit.simple2.servlet;

import int202.sit.simple2.entities.Subject;
import int202.sit.simple2.repositories.SubjectRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectListServlet", value = "/SubjectList")
public class SubjectListServlet extends HttpServlet {
    private long startTime;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = (List) new SubjectRepository().findAll();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/subject_listing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("This servlet lift time is " + (System.currentTimeMillis() - startTime) + " milliseconds.");
    }

    @Override
    public void init() throws ServletException {
        startTime = System.currentTimeMillis();
    }
}