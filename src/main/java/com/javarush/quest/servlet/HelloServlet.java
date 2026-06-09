package com.javarush.quest.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer.println(
                "<html>" +
                        "<head>" +
                        "<title>Hello Quest</title>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Text Quest успешно запущен</h1>" +
                        "</body>" +
                        "</html>"
        );
    }
}