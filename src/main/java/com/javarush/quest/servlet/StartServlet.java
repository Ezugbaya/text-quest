package com.javarush.quest.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/start.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String playerName = request.getParameter("playerName");

        HttpSession session = request.getSession();

        session.invalidate();

        session = request.getSession();

        session.setAttribute("playerName", playerName);

        session.setAttribute("stepsCount", 0);

        response.sendRedirect("game");
    }
}