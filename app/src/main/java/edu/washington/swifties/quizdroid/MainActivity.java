package edu.washington.swifties.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
  public static final String SUBJECT = "SUBJECT";
  public static final String DESC = "DESC";

  public static final String QUESTION = "question";
  public static final String ANSWER_1 = "answer1";
  public static final String ANSWER_2 = "answer2";
  public static final String ANSWER_3 = "answer3";
  public static final String ANSWER_4 = "answer4";
  public static final String CORRECT_ANSWER = "correct_answer";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    QuizApp app = new QuizApp();
    TopicRepository repo = new TopicRepository();
    final List<Topic> topics = repo.getTopics();

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, repo.getSubjects());

    ListView listView = (ListView) findViewById(R.id.listView);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra(SUBJECT, (String) adapterView.getItemAtPosition(i));
        intent.putExtra(DESC, topics.get(i).getLongDesc());

        intent.putExtra(QUESTION, topics.get(i).getQuestions().get(0).getQuestion());
        intent.putExtra(ANSWER_1, topics.get(i).getQuestions().get(0).getAnswer(0));
        intent.putExtra(ANSWER_2, topics.get(i).getQuestions().get(0).getAnswer(1));
        intent.putExtra(ANSWER_3, topics.get(i).getQuestions().get(0).getAnswer(2));
        intent.putExtra(ANSWER_4, topics.get(i).getQuestions().get(0).getAnswer(3));
        intent.putExtra(CORRECT_ANSWER, topics.get(i).getQuestions().get(0).getRightAnswer());
        startActivity(intent);
      }
    });
  }
}
