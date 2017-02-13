package edu.washington.swifties.quizdroid;

import android.app.Application;
import android.util.Log;

/**
 * Created by yulong on 2/12/17.
 */

public class QuizApp extends Application {

  private TopicRepository instance = new TopicRepository();

  public QuizApp() {
    Log.d("QuizApp", "Constructor fired");
  }

  public TopicRepository getRepository() {
    return this.instance;
  }
}
