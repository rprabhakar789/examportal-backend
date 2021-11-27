package com.backend.examPortal.entity.quiz;

public class Answer {
    private int quizId;
    private int questionId;
    private String answer;

    public Answer(int quizId, int questionId, String answer) {
        this.quizId = quizId;
        this.questionId = questionId;
        this.answer = answer;
    }

    public Answer() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "quizId=" + quizId +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
