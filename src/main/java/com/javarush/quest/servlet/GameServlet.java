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

        printStep(request, response, session, step);
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
        } else {

            nextStep = step.getSecondNextStep();
        }

        session.setAttribute("currentStep", nextStep);

        Integer stepsCount =
                (Integer) session.getAttribute("stepsCount");

        stepsCount++;

        session.setAttribute("stepsCount", stepsCount);

        response.sendRedirect("game");


    }

    private void printStep(HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session,
                           QuestStep step)
            throws ServletException, IOException {

        String playerName =
                (String) session.getAttribute("playerName");

        Integer stepsCount =
                (Integer) session.getAttribute("stepsCount");

        request.setAttribute(
                "playerName",
                playerName
        );

        request.setAttribute(
                "stepsCount",
                stepsCount
        );

        request.setAttribute(
                "question",
                step.getQuestion()
        );

        request.setAttribute(
                "firstAnswer",
                step.getFirstAnswer()
        );

        request.setAttribute(
                "secondAnswer",
                step.getSecondAnswer()
        );

        request.setAttribute(
                "finalStep",
                step.isFinalStep()
        );

        if (step.isFinalStep()) {

            if (step.getId().contains("win")) {

                request.setAttribute(
                        "result",
                        "ПОБЕДА"
                );
            } else {

                request.setAttribute(
                        "result",
                        "ПОРАЖЕНИЕ"
                );
            }
        }

        request.getRequestDispatcher(
                "/game.jsp"
        ).forward(request, response);
    }
}