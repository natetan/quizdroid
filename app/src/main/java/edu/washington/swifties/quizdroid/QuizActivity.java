package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity {
  private FragmentTransaction tx = getFragmentManager().beginTransaction();
  private Fragment display = null;

  private Button beginButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz);

    String subject = getIntent().getStringExtra(MainActivity.SUBJECT);
    String desc = getIntent().getStringExtra(MainActivity.DESC);

    String question = getIntent().getStringExtra(MainActivity.QUESTION);
    String answer1 = getIntent().getStringExtra(MainActivity.ANSWER_1);
    String answer2 = getIntent().getStringExtra(MainActivity.ANSWER_2);
    String answer3 = getIntent().getStringExtra(MainActivity.ANSWER_3);
    String answer4 = getIntent().getStringExtra(MainActivity.ANSWER_4);
    int rightAnswer = getIntent().getIntExtra(MainActivity.CORRECT_ANSWER, -1);

    TextView subjectTextView = (TextView) findViewById(R.id.subjectTextView);
    subjectTextView.setText(subject);

    display = new DescFragment();
    Bundle bundle = new Bundle();

    bundle.putString(MainActivity.DESC, desc);

    bundle.putString(MainActivity.QUESTION, question);
    bundle.putString(MainActivity.ANSWER_1, answer1);
    bundle.putString(MainActivity.ANSWER_2, answer2);
    bundle.putString(MainActivity.ANSWER_3, answer3);
    bundle.putString(MainActivity.ANSWER_4, answer4);
    bundle.putInt(MainActivity.CORRECT_ANSWER, rightAnswer);

    display.setArguments(bundle);
    tx.replace(R.id.fragment_placeholder, display);
    tx.commit();
  }
}
