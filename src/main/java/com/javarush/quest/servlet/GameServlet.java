package com.javarush.quest.servlet;

import com.javarush.quest.model.QuestStep;
import com.javarush.quest.service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

public class GameServlet extends HttpServlet {

    private static final Logger logger =
            Logger.getLogger(GameServlet.class.getName());

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

            session.setAttribute(
                    "currentStep",
                    currentStep
            );
        }

        QuestStep step =
                questService.getStep(currentStep);

        printStep(
                request,
                response,
                session,
                step
        );
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        String currentStep =
                (String) session.getAttribute("currentStep");

        QuestStep step =
                questService.getStep(currentStep);

        String answer =
                request.getParameter("answer");

        logger.info(
                "Игрок выбрал вариант: " + answer
        );

        String nextStep;

        if ("1".equals(answer)) {

            nextStep =
                    step.getFirstNextStep();

        } else {

            nextStep =
                    step.getSecondNextStep();
        }

        session.setAttribute(
                "currentStep",
                nextStep
        );

        Integer stepsCount =
                (Integer) session.getAttribute("stepsCount");

        stepsCount++;

        session.setAttribute(
                "stepsCount",
                stepsCount
        );

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

            logger.info(
                    "Игра завершена. Концовка: "
                            + step.getId()
            );

            if (step.getId().equals("winEscape")) {

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