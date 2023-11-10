package sit.int202.mymidterm.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.mymidterm.model.HistoryPrime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PrimerServlet", value = "/is_prime")
public class PrimerServlet extends HttpServlet {
    List<HistoryPrime> historyPrimeList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/primer_check.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getNumberForm = request.getParameter("number");
        if (getNumberForm == null || !isDigit(getNumberForm)) {
            request.setAttribute("erMSG", getNumberForm + " is invalid input !!!");
        }
        else {
            int number = Integer.parseInt(getNumberForm);
            if (isPrime(number)) request.setAttribute("passMSG", getNumberForm + " is prime number");
            else request.setAttribute("passMSG", getNumberForm + " is not prime number");
            historyPrimeList.add(new HistoryPrime(number, isPrime(number)));
            HttpSession session = request.getSession();
            session.setAttribute("historyList", historyPrimeList);
        }
        request.getRequestDispatcher("/primer_check.jsp").forward(request, response);
    }

    private boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private boolean isDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) return false;
        }
        return true;
    }
}