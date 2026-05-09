package com.javarush.quest.model;

public class QuestStep {

    private String id;

    private String question;

    private String firstAnswer;

    private String secondAnswer;

    private String firstNextStep;

    private String secondNextStep;

    private boolean finalStep;

    public QuestStep(String id,
                     String question,
                     String firstAnswer,
                     String secondAnswer,
                     String firstNextStep,
                     String secondNextStep,
                     boolean finalStep) {

        this.id = id;
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.firstNextStep = firstNextStep;
        this.secondNextStep = secondNextStep;
        this.finalStep = finalStep;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getFirstNextStep() {
        return firstNextStep;
    }

    public String getSecondNextStep() {
        return secondNextStep;
    }

    public boolean isFinalStep() {
        return finalStep;
    }
}
