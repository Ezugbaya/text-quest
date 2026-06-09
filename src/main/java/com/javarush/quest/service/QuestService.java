package com.javarush.quest.service;

import com.javarush.quest.model.QuestStep;

import java.util.HashMap;
import java.util.Map;

public class QuestService {

    private final Map<String, QuestStep> steps = new HashMap<>();

    public QuestService() {
        initSteps();
    }

    private void initSteps() {

        // СТАРТ

        steps.put("start",
                new QuestStep(
                        "start",

                        "Ты очнулся на неизвестном космическом корабле после сильного удара. " +
                                "В памяти всплывает последнее событие — тебя похитили пришельцы. " +
                                "Во время полета в корабль что-то врезалось, после чего ты потерял сознание. " +
                                "Теперь вокруг пусто, свет мигает, а вдалеке слышны странные звуки.",

                        "Пойти в коридор",
                        "Осмотреть окно",

                        "corridor",
                        "wndow",

                        false
                )
        );



        // ОКНО -> ПОРАЖЕНИЕ

        steps.put("wndow",
                new QuestStep(
                        "wndow",

                        "Ты подошел к окну. За стеклом — открытый космос и обломки корабля. " +
                                "В этот момент корпус разгерметизировался.",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );



        // КОРИДОР

        steps.put("corridor",
                new QuestStep(
                        "corridor",

                        "Ты вышел в темный коридор корабля. Вдалеке мигает аварийное освещение.",

                        "Спуститься в низ",
                        "Подняться наверх",

                        "basement",
                        "upperLevel",

                        false
                )
        );



        // НИЗ -> ПОРАЖЕНИЕ

        steps.put("basement",
                new QuestStep(
                        "basement",

                        "Ты спустился в технический отсек. Дверь захлопнулась, и помещение начало заполняться газом.",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );



        // ВЕРХНИЙ УРОВЕНЬ

        steps.put("upperLevel",
                new QuestStep(
                        "upperLevel",

                        "Ты поднялся на верхний уровень корабля.",

                        "Пойти в комнату капитана",
                        "Пройти дальше по коридору",

                        "captainRoom",
                        "longCorridor",

                        false
                )
        );



        // КАПИТАН -> ПОРАЖЕНИЕ

        steps.put("captainRoom",
                new QuestStep(
                        "captainRoom",

                        "Ты вошел в комнату капитана. Тебя сразу заметил капитан пришельцев.",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );



        // ДАЛЬНИЙ КОРИДОР

        steps.put("longCorridor",
                new QuestStep(
                        "longCorridor",

                        "Ты осторожно прошел дальше по коридору. Вдалеке что-то мигает.",

                        "Подойти к свечению",
                        "Осмотреть эвакуационный отсек",

                        "electricDeath",
                        "winEscape",

                        false
                )
        );



        // ЭЛЕКТРИЧЕСТВО -> ПОРАЖЕНИЕ

        steps.put("electricDeath",
                new QuestStep(
                        "electricDeath",

                        "Ты подошел ближе. Оголенный кабель ударил тебя током.",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );



        // ПОБЕДА

        steps.put("winEscape",
                new QuestStep(
                        "winEscape",

                        "Ты нашел спасательную капсулу и покинул корабль.",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );
    }

    public QuestStep getStep(String id) {
        return steps.get(id);
    }
}