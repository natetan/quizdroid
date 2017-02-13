package edu.washington.swifties.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulong on 2/12/17.
 */

public class TopicRepository {

  private String[] subjects = {
      "Math", "Physics", "Marvel Superheroes"
  };

  private String[] desc = {
      "Do you find yourself better at math than your peers? Do you know what the absolute value of 2 is? This may just be the quiz for you!",
      "Velocity, acceleration, force! What do these words mean? Maybe you can answer them!",
      "What is Iron Man's secret identity? Who is Spider-Man's crime-fighting partner and lover? Test your Marvel comics knowledge!"
  };

  private String[] questions = {
      "What is 2 + 2?",
      "What is gravity?",
      "Who is Spider-Man's crime-fighting partner and lover?"
  };

  private String[] answers1 = {
      "I don't know", "3?", "4", "22"
  };

  private String[] answers2 = {
      "The thing that sucks you down", "Being fat", "The situation you're in right now", "This is too hard"
  };

  private String[] answers3 = {
      "Gwen Stacy",
      "Mary Jane",
      "Liz Allan",
      "Felicia Hardy"
  };

  // 0 index based
  private int[] answers = {
      2, 2, 3
  };

  private String[][] answersList = {
      answers1, answers2, answers3
  };

  private List<Topic> topics = new ArrayList<>();

  public TopicRepository() {
    for (int i = 0; i < subjects.length; i++) {
      Question q = new Question(questions[i], answersList[i][0], answersList[i][1],
          answersList[i][2], answersList[i][3], answers[i]);
      this.topics.add(new Topic(subjects[i], "No short desc yet", desc[i], q));
    }
  }

  public List<Topic> getTopics() {
    return this.topics;
  }

  public String[] getSubjects() {
    return this.subjects;
  }

}
