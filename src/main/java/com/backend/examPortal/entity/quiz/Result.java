package com.backend.examPortal.entity.quiz;

public class Result {
    int quizId;
    int noOfQues;
    int totalMarks;
    int correctAnswers;
    double marksScored;

    public Result(int quizId, int noOfQues, int totalMarks, int correctAnswers, double marksScored) {
        this.quizId = quizId;
        this.noOfQues = noOfQues;
        this.totalMarks = totalMarks;
        this.correctAnswers = correctAnswers;
        this.marksScored = marksScored;
    }
    public Result(){

    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getNoOfQues() {
        return noOfQues;
    }

    public void setNoOfQues(int noOfQues) {
        this.noOfQues = noOfQues;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public double getMarksScored() {
        return marksScored;
    }

    public void setMarksScored(double marksScored) {
        this.marksScored = marksScored;
    }
}
