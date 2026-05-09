package com.javarush.quest.servlet;

import com.javarush.quest.model.QuestStep;
import com.javarush.quest.service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class GameServlet extends HttpServlet {

    private final QuestService questService =
            new QuestService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String currentStep =
                (String) session.getAttribute("currentStep");

        if (currentStep == null) {

            currentStep = "start";

            session.setAttribute("currentStep", currentStep);
        }

        QuestStep step =
                questService.getStep(currentStep);

        printStep(response, session, step);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String currentStep =
                (String) session.getAttribute("currentStep");

        QuestStep step =
                questService.getStep(currentStep);

        String answer =
                request.getParameter("answer");

        String nextStep;

        if ("1".equals(answer)) {

            nextStep = step.getFirstNextStep();
        }

        else {

            nextStep = step.getSecondNextStep();
        }

        session.setAttribute("currentStep", nextStep);

        Integer stepsCount =
                (Integer) session.getAttribute("stepsCount");

        stepsCount++;

        session.setAttribute("stepsCount", stepsCount);

        response.sendRedirect("game");
    }

    private void printStep(HttpServletResponse response,
                           HttpSession session,
                           QuestStep step)
            throws IOException {

        PrintWriter writer = response.getWriter();

        String playerName =
                (String) session.getAttribute("playerName");

        Integer stepsCount =
                (Integer) session.getAttribute("stepsCount");

        writer.println("<html><body>");

        writer.println("<h2>Игрок: " +
                playerName + "</h2>");

        writer.println("<h3>Ходов: " +
                stepsCount + "</h3>");

        writer.println("<h1>" +
                step.getQuestion() + "</h1>");

        // ЕСЛИ ФИНАЛ

        if (step.isFinalStep()) {

            if (step.getId().contains("win")) {

                writer.println("<h2>ПОБЕДА</h2>");
            }

            else {

                writer.println("<h2>ПОРАЖЕНИЕ</h2>");
            }

            writer.println(
                    "<a href='start.jsp'>Начать заново</a>"
            );
        }

        // ОБЫЧНЫЙ ШАГ

        else {

            writer.println(
                    "<form action='game' method='post'>"
            );

            writer.println(
                    "<button name='answer' value='1'>"
                            + step.getFirstAnswer() +
                            "</button>"
            );

            writer.println("<br><br>");

            writer.println(
                    "<button name='answer' value='2'>"
                            + step.getSecondAnswer() +
                            "</button>"
            );

            writer.println("</form>");
        }

        writer.println("</body></html>");
    }
}