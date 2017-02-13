package edu.washington.swifties.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic domain object - consists of a title, short description, long description,
 * and a list of questions
 */

public class Topic {
  private String title, shortDesc, longDesc;
  private List<Question> questions = new ArrayList<>();


  public Topic(String title, String shortDesc, String longDesc, Question question) {
    this.title = title;
    this.shortDesc = shortDesc;
    this.longDesc = longDesc;
    this.questions.add(question);
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShortDesc() {
    return this.shortDesc;
  }

  public void setShortDesc(String shortDesc) {
    this.shortDesc = shortDesc;
  }

  public String getLongDesc() {
    return this.longDesc;
  }

  public void setLongDesc(String longDesc) {
    this.longDesc = longDesc;
  }

  public List<Question> getQuestions() {
    return this.questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = new ArrayList<>(questions);
  }

  public String toString() {
    return "[" +
        "Title: " + this.title + "\n" +
        "Short Desc: " + this.shortDesc + "\n" +
        "Long Desc: " + this.longDesc + "\n" +
        "Questions: " + this.questions.toString() + "\n" +
        "]";
  }
}
