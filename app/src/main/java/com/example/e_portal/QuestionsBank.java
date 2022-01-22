package com.example.e_portal;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> topic1Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Find the differentiation of\n","\\(x^3 + y^3 - 3xy + y^2 = 0\\)", "\\((x^2 - y)/(x - y^2 - 2y)\\)", "\\((3^2 - 3y)/(3x - 3y^2 - 2y)\\)", "\\((3x^3 - 3y)/(3x - 3y^2 - 2y)\\)", "\\((3x^2 - y)/(3x -3y^2 -y)\\)", "\\((3^2 - 3y)/(3x - 3y^2 - 2y)\\)", "");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic2Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Find the derivative of\n","\\((X)^{log 2}\\)"+"with respect to"+"\\(X\\)", "\\(X^{x-1} (log x^2)\\)", "\\(X^{log x-1} (log X^2)\\)", "\\(X^{log x} (log X^2)\\)", "\\(X^{log 2} (log X^2)\\)", "\\(X^(log x-1) (log X^2)\\)", "");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic3Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Find dy/dx of\n","\\(y = e^{7e^x}\\)", "\\(7xe^{7e^x}\\)", "\\(7e^{7e^x + 1}\\)", "\\(7e^{7e^x + x}\\)", "\\(7e^{7e^x}\\)", "\\(7e^{7e^x + x}\\)","");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic4Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Find the local linear approximation of\n","\\(f(x)= √x  at x_0= 1\\)", "\\(y=1+1/2(x+1)\\)", "\\(y=1+1/2(x-1)\\)", "\\(y=1-1/2(x-1)\\)", "\\(y=1-1/2(x+1)\\)", "\\(y=1-1/2(x-1)\\)","");
        questionsLists.add(question1);
        return questionsLists;
    }

    private static List<QuestionsList> topic5Questions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Calculate the following limit\n","lim┬(n→∞)\u2061((5x^2+2x+1)/(x^4+2))", "∞", "5/6", "12", "0", "0","");
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