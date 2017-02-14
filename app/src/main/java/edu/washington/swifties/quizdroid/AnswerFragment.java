package edu.washington.swifties.quizdroid;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnswerFragment extends Fragment {
  private Button nextPageButton;
  private TextView resultTextView, correctAnswerTextView, answerChosenTextView;
  private boolean isRight;
  private String result = "INCORRECT";


  public AnswerFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_answer, container, false);

    isRight = getArguments().getBoolean(QuestionFragment.IS_RIGHT);
    final String correctAnswerText = getArguments().getString(QuestionFragment.CORRECT_ANSWER_TEXT);
    final String selectedAnswerText = getArguments().getString(QuestionFragment.SELECTED_ANSWER);

    if (isRight) {
      result = "CORRECT";
    }

    resultTextView = (TextView) view.findViewById(R.id.resultTextView);
    resultTextView.setText(result);

    correctAnswerTextView = (TextView) view.findViewById(R.id.correctAnswerTextView);
    correctAnswerTextView.setText("Correct answer: " + correctAnswerText);

    answerChosenTextView = (TextView) view.findViewById(R.id.answerChosenTextView);
    answerChosenTextView.setText("You said: " + selectedAnswerText);

    nextPageButton = (Button) view.findViewById(R.id.nextPageButton);
    nextPageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
      }
    });

    return view;
  }

}
