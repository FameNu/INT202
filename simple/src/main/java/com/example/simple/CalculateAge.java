package com.example.simple;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet(name = "CalculateAge", value = "/CalculateAge")
public class CalculateAge extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String birthYear = request.getParameter("year");
        String birthMonth = request.getParameter("month");
        String birthDay = request.getParameter("date");
        int birthYearValue = Integer.valueOf(birthYear);
        int birthMonthValue = Integer.valueOf(birthMonth);
        int birthDayValue = Integer.valueOf(birthDay);
//        int age = 2564 - birthYearValue;
        // auto get current year, month, day
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // month start from 0
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        // calculate age by year, month, day
        int ageYear = currentYear - birthYearValue - 543;
        int ageMonth = currentMonth - birthMonthValue;
        int ageDay = currentDay - birthDayValue;
        // check if ageDay < 0
        if (ageDay < 0) {
            ageMonth--;
            ageDay += 30;
        }
        // check if ageMonth < 0
        if (ageMonth < 0) {
            ageYear--;
            ageMonth += 12;
        }
        // print age
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your Age:</h1>");
        out.println("Birth Year: " + birthYear + "<br>");
        out.println("Birth Month: " + birthMonth + "<br>");
        out.println("Birth Day: " + birthDay + "<br>");
        out.println("Age: " + ageYear + " years " + ageMonth + " months " + ageDay + " days<br>");
        out.println("</body></html>");
    }
}