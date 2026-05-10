package com.javarush.quest.service;

import com.javarush.quest.model.QuestStep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {

    private final QuestService questService =
            new QuestService();

    @Test
    void testStartStepExists() {

        QuestStep step =
                questService.getStep("start");

        assertNotNull(step);

        assertEquals(
                "start",
                step.getId()
        );
    }

    @Test
    void testCorridorStepExists() {

        QuestStep step =
                questService.getStep("corridor");

        assertNotNull(step);

        assertEquals(
                "corridor",
                step.getId()
        );
    }

    @Test
    void testWindowIsLose() {

        QuestStep step =
                questService.getStep("wndow");

        assertTrue(step.isFinalStep());

        assertNotEquals(
                "winEscape",
                step.getId()
        );
    }

    @Test
    void testWinEscapeIsWin() {

        QuestStep step =
                questService.getStep("winEscape");

        assertTrue(step.isFinalStep());

        assertEquals(
                "winEscape",
                step.getId()
        );
    }

    @Test
    void testUpperLevelBranches() {

        QuestStep step =
                questService.getStep("upperLevel");

        assertEquals(
                "captainRoom",
                step.getFirstNextStep()
        );

        assertEquals(
                "longCorridor",
                step.getSecondNextStep()
        );
    }

    @Test
    void testLongCorridorBranches() {

        QuestStep step =
                questService.getStep("longCorridor");

        assertEquals(
                "electricDeath",
                step.getFirstNextStep()
        );

        assertEquals(
                "winEscape",
                step.getSecondNextStep()
        );
    }
}