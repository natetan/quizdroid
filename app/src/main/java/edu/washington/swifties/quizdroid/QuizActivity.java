package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

public class QuizActivity extends Activity {
  private FragmentTransaction tx = getFragmentManager().beginTransaction();
  private Fragment display = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz);

    String subject = getIntent().getStringExtra("SUBJECT");
    String desc = getIntent().getStringExtra("DESC");

    TextView subjectTextView = (TextView) findViewById(R.id.subjectTextView);
    subjectTextView.setText(subject);

    // Testing initial frag swap
    display = new DescFragment();
    tx.replace(R.id.fragment_placeholder, display);
    tx.commit();
  }
}
