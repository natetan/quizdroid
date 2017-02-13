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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
  private RadioGroup choices;
  private TextView questionTextView;
  private Button submitButton;
  private int selectedAnswer;

  public static final String SELECTED_ANSWER = "selected_answer";

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

    submitButton = (Button) view.findViewById(R.id.submitButton);
    submitButton.setVisibility(View.INVISIBLE);
    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Fragment next = new AnswerFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(SELECTED_ANSWER, selectedAnswer);
        next.setArguments(bundle);

        FragmentManager fm = getActivity().getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.fragment_placeholder, next);
        tx.addToBackStack(null);
        tx.commit();
      }
    });

    choices = (RadioGroup) view.findViewById(R.id.choices);

    for (int i = 0; i < choices.getChildCount(); i++) {
      ((RadioButton) choices.getChildAt(i)).setText(answers[i]);
    }

    choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {
        submitButton.setVisibility(View.VISIBLE);
        // Gets the id of the RadioButton selected
        int id = choices.getCheckedRadioButtonId();
        // Gets the actual radio button that is clicked (so we can grab text)
        RadioButton rb = (RadioButton) view.findViewById(id);
        selectedAnswer = i;
        Log.d("QuestionFragment", "QUESTION FRAG RADIO INDEX: " + selectedAnswer);
      }
    });

    return view;
  }

}
