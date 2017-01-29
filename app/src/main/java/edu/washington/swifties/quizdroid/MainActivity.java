package edu.washington.swifties.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private String[] subjects = {
      "Math", "Physics", "Marvel Superheroes"
  };

  private String[] desc = {
    "Do you find yourself better at math than your peers? Do you know what the absolute value of 2 is? This may just be the quiz for you!",
      "Velocity, acceleration, force! What do these words mean? Maybe you can answer them!",
      "What is Iron Man's secret identity? Who is Spider-Man's crime-fighting partner and lover? Test your Marvel comics knowledge!"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, subjects);

    ListView listView = (ListView) findViewById(R.id.listView);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
        intent.putExtra("SUBJECT", (String) adapterView.getItemAtPosition(i));
        intent.putExtra("DESC", desc[i]);
        startActivity(intent);
      }
    });
  }
}
