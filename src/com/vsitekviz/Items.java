package com.vsitekviz;

public class Items {
	
	int id;
    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String correctAnswer;
    // Constructor
    public Items(){
    }
    // Constructor
    public Items(int id){
    	this.id = id;
    }
    // Constructor
    public Items(int id, String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer){
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }
    // Constructor
    public Items(String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer){
    	this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }
    // getting ID
    public int getID(){
        return this.id;
    }
    // setting id
    public void setID(int id){
        this.id = id;
    }
    // getting question
    public String getQuestion(){
        return this.question;
    } 
    // setting question
    public void setQuestion(String question){
        this.question = question;
    }
    // getting answer1
    public String getAnswer1(){
        return this.answer1;
    }
    // setting answer1
    public void setAnswer1(String answer1){
        this.answer1 = answer1;
    }
    // getting answer2
    public String getAnswer2(){
        return this.answer2;
    }
    // setting answer2
    public void setAnswer2(String answer2){
        this.answer2 = answer2;
    }
    // getting answer3
    public String getAnswer3(){
        return this.answer3;
    }
    // setting answer3
    public void setAnswer3(String answer3){
        this.answer3 = answer3;
    }
    // getting answer4
    public String getAnswer4(){
        return this.answer4;
    }
    // setting answer4
    public void setAnswer4(String answer4){
        this.answer4 = answer4;
    }
 // getting correct answer
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
    // setting correct answer
    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer = correctAnswer;
    }
}
