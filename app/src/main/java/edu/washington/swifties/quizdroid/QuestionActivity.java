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
        // Gets the id of the RadioButton selected
        int id = choices.getCheckedRadioButtonId();
        // Gets the actual radio button that is clicked (so we can grab text)
        RadioButton rb = (RadioButton) findViewById(id);
      }
    });

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
