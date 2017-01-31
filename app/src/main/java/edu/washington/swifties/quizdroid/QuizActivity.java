package edu.washington.swifties.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz);

    String subject = getIntent().getStringExtra("SUBJECT");
    String desc = getIntent().getStringExtra("DESC");
  }
}
