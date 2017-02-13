package edu.washington.swifties.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Question domain object - consists of a question, 4 answers, and an integer representing
 * the correct answer.
 */

public class Question {
  private String question;
  private int answer;
  private List<String> answersList = new ArrayList<>();

  public Question(String question, String answer1, String answer2, String answer3,
                  String answer4, int answer) {
    this.question = question;
    this.answer = answer;

    this.answersList.add(answer1);
    this.answersList.add(answer2);
    this.answersList.add(answer3);
    this.answersList.add(answer4);
  }

  public String getQuestion() {
    return this.question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  // 0 base indexing
  public String getAnswer(int num) {
    if (num < 0 || num > 3) {
      throw new IllegalArgumentException("Number must be between 0 and 3, both inclusive");
    }
    return this.answersList.get(num);
  }

  public List<String> getAnswers() {
    return this.answersList;
  }

  public int getRightAnswer() {
    return this.answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  public String toString() {
    return "[Question: " + this.question + "\n" +
        "answer1: " + this.answersList.get(1) + "\n" +
        "answer2: " + this.answersList.get(2) + "\n" +
        "answer3: " + this.answersList.get(3) + "\n" +
        "answer4: " + this.answersList.get(4) + "\n" +
        "Right answer: " + this.answer + "\n" +
        "]";
  }
}
