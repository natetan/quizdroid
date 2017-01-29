package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OverviewActivity extends Activity {
  private TextView subjectTextView;
  private TextView descTextView;
  private Button beginButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_overview);
    String subject = getIntent().getStringExtra("SUBJECT");
    String desc = getIntent().getStringExtra("DESC");

    subjectTextView = (TextView) findViewById(R.id.subjectTextView);
    subjectTextView.setText(subject);

    descTextView = (TextView) findViewById(R.id.descTextView);
    descTextView.setText(desc);

    beginButton = (Button) findViewById(R.id.beginButton);
    beginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(OverviewActivity.this, QuestionActivity.class);
        startActivity(intent);
      }
    });

  }
}
