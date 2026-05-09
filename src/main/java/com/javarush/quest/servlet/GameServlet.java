package com.javarush.quest.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        String playerName =
                (String) session.getAttribute("playerName");

        writer.println(
                "<html>" +
                        "<head>" +
                        "<title>Game</title>" +
                        "</head>" +

                        "<body>" +

                        "<h1>" + playerName + ", ты проснулся в тёмной комнате</h1>" +

                        "<form action='game' method='post'>" +

                        "<button name='choice' value='door'>" +
                        "Открыть дверь" +
                        "</button>" +

                        "<br><br>" +

                        "<button name='choice' value='window'>" +
                        "Посмотреть в окно" +
                        "</button>" +

                        "</form>" +

                        "</body>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String choice = request.getParameter("choice");

        PrintWriter writer = response.getWriter();

        writer.println("<html><body>");

        if ("door".equals(choice)) {
            writer.println("<h1>Ты открыл дверь и вышел наружу</h1>");
        }

        else if ("window".equals(choice)) {
            writer.println("<h1>За окном была буря</h1>");
        }

        writer.println("</body></html>");
    }
}