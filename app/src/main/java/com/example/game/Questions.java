package com.example.game;

public class Questions {

    private String question;
    private int id;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String cor_answer;

    public Questions(){}

   public Questions (String question, int id, String answer1, String answer2, String answer3, String answer4, String cor_answer) {

       this.question = question;
       this.id = id;
       this.answer1 = answer1;
       this.answer2 = answer2;
       this.answer3 = answer3;
       this.answer4 = answer4;
       this.cor_answer = cor_answer;


   }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCor_answer() {
        return cor_answer;
    }

    public void setCor_answer(String cor_answer) {
        this.cor_answer = cor_answer;
    }
}
