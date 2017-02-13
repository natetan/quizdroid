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
        intent.putExtra("SUBJECT", (String) adapterView.getItemAtPosition(i));
        intent.putExtra("DESC", topics.get(i).getLongDesc());
        startActivity(intent);
      }
    });
  }
}
