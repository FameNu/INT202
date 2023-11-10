package sit.int202.mymidterm.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.mymidterm.model.User;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", null);
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = new User(username, email);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
//        response.sendRedirect("register.jsp");
//        request.setAttribute("username", username);
//        request.setAttribute("email", email);
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}