package com.javarush.quest.service;

import com.javarush.quest.model.QuestStep;

import java.util.HashMap;
import java.util.Map;

public class QuestService {

    private final Map<String, QuestStep> steps =
            new HashMap<>();

    public QuestService() {

        initSteps();
    }

    private void initSteps() {



        steps.put("start",
                new QuestStep(
                        "start",

                        "Ты проснулся на заброшенной космической станции",

                        "Пойти в коридор",
                        "Посмотреть в окно",

                        "corridor",
                        "loseWindow",

                        false
                )
        );



        steps.put("corridor",
                new QuestStep(
                        "corridor",

                        "Ты вошел в темный коридор",

                        "Подняться наверх",
                        "Спуститься в подвал",

                        "winEscape",
                        "loseBasement",

                        false
                )
        );



        steps.put("winEscape",
                new QuestStep(
                        "winEscape",

                        "Ты нашел спасательный корабль",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );



        steps.put("loseWindow",
                new QuestStep(
                        "loseWindow",

                        "Через окно тебя заметило неизвестное существо",

                        "",
                        "",

                        "",
                        "",

                        true
                )
        );



        steps.put("loseBasement",
                new QuestStep(
                        "loseBasement",

                        "В подвале оказалась ловушка",

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