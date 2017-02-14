package edu.washington.swifties.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
  private RadioGroup choices;
  private TextView questionTextView;
  private Button submitButton;
  private int selectedAnswer;
  private String selectedAnswerText;
  private boolean isRight = false;

  public static final String SELECTED_ANSWER = "selected_answer";
  public static final String IS_RIGHT = "is_right";
  public static final String CORRECT_ANSWER_TEXT = "correct_answer_text";

  public QuestionFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.fragment_question, container, false);

    final String question = getArguments().getString(MainActivity.QUESTION);
    final String answer1 = getArguments().getString(MainActivity.ANSWER_1);
    final String answer2 = getArguments().getString(MainActivity.ANSWER_2);
    final String answer3 = getArguments().getString(MainActivity.ANSWER_3);
    final String answer4 = getArguments().getString(MainActivity.ANSWER_4);
    final int rightAnswer = getArguments().getInt(MainActivity.CORRECT_ANSWER);

    questionTextView = (TextView) view.findViewById(R.id.questionTextView);
    questionTextView.setText(question);

    String[] answers = {
        answer1, answer2, answer3, answer4
    };

    choices = (RadioGroup) view.findViewById(R.id.choices);

    for (int i = 0; i < choices.getChildCount(); i++) {
      ((RadioButton) choices.getChildAt(i)).setText(answers[i]);
    }

    submitButton = (Button) view.findViewById(R.id.submitButton);
    submitButton.setVisibility(View.INVISIBLE);
    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Fragment next = new AnswerFragment();

        String correctAnswerText = ((RadioButton) choices.getChildAt(rightAnswer)).getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.QUESTION, question);
        bundle.putString(SELECTED_ANSWER, selectedAnswerText);
        bundle.putString(CORRECT_ANSWER_TEXT, correctAnswerText);

        Log.d("QUESTIONFRAG", "RIGHT ANSWER QF: " + rightAnswer);
        Log.d("QUESTIONFRAG", "SELECTED ANSWER: " + selectedAnswer);
        if (rightAnswer == selectedAnswer) {
          isRight = true;
        }

        bundle.putBoolean(IS_RIGHT, isRight);

        next.setArguments(bundle);

        FragmentManager fm = getActivity().getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.fragment_placeholder, next);
        tx.addToBackStack(null);
        tx.commit();
      }
    });

    choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {
        submitButton.setVisibility(View.VISIBLE);
        // Gets the id of the RadioButton selected
        int id = choices.getCheckedRadioButtonId();
        // Gets the actual radio button that is clicked (so we can grab text)
        RadioButton rb = (RadioButton) view.findViewById(id);
        selectedAnswerText = rb.getText().toString();
        selectedAnswer = choices.indexOfChild(view.findViewById(choices.getCheckedRadioButtonId()));
      }
    });

    return view;
  }

}
