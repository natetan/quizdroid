package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;

public class QuestionActivity extends Activity {
  private RadioButton choice1, choice2, choice3, choice4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    choice1 = (RadioButton) findViewById(R.id.choice1);
    choice2 = (RadioButton) findViewById(R.id.choice2);
    choice3 = (RadioButton) findViewById(R.id.choice3);
    choice4 = (RadioButton) findViewById(R.id.choice4);
  }
}
