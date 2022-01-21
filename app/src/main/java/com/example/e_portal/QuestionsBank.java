package com.example.e_portal;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> topic1Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Q1", "A", "B", "C", "D", "B", "");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic2Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Q2", "A", "B", "C", "D", "B", "");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic3Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Q3", "A", "B", "C", "D", "C","");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic4Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Q4", "A", "B", "C", "D", "C","");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic5Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Q5", "A", "B", "C", "D", "D","");
        questionsLists.add(question1);
        return questionsLists;
    }

    public static List<QuestionsList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "topic1":
                return topic1Questions();
            case "topic2":
                return topic2Questions();
            case "topic3":
                return topic3Questions();
            case "topic4":
                return topic4Questions();
            default:
                return topic5Questions();
        }
    }
}