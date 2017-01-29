package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.content.Intent;
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
  private int answerSelected = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    submitButton = (Button) findViewById(R.id.submitButton);
    submitButton.setVisibility(View.INVISIBLE);
    choices = (RadioGroup) findViewById(R.id.choices);
    choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {
        submitButton.setVisibility(View.VISIBLE);
        answerSelected = i;
      }
    });

    RadioButton[] rbs = {choice1, choice2, choice3, choice4};
    int[] ids = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4};

    for (int i = 0; i < rbs.length; i++) {
      rbs[i] = (RadioButton) findViewById(ids[i]);

    }

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(QuestionActivity.this, ResultsActivity.class);
        intent.putExtra("ANSWER SELECTED", answerSelected);
        startActivity(intent);
      }
    });
  }
}
