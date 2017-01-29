package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionActivity extends Activity {
  private RadioGroup choices;
  private RadioButton choice1, choice2, choice3, choice4;
  private TextView questionTextView;
  private Button submitButton;
  private boolean selected = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);
    choices = (RadioGroup) findViewById(R.id.choices);
    RadioButton[] rbs = {choice1, choice2, choice3, choice4};
    int[] ids = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4};

    for (int i = 0; i < rbs.length; i++) {
      rbs[i] = (RadioButton) findViewById(ids[i]);
    }

    submitButton = (Button) findViewById(R.id.submitButton);
    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });
  }
}
