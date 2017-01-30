package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends Activity {
  private Button nextPageButton;
  private TextView resultTextView, correctAnswerTextView, answerChosenTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_results);

    nextPageButton = (Button) findViewById(R.id.nextPageButton);

    resultTextView = (TextView) findViewById(R.id.resultTextView);
    correctAnswerTextView = (TextView) findViewById(R.id.correctAnswerTextView);
    answerChosenTextView = (TextView) findViewById(R.id.answerChosenTextView);

    nextPageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(intent);
      }
    });
  }
}
