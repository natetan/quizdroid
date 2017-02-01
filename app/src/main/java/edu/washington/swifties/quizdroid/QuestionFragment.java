package edu.washington.swifties.quizdroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

  public QuestionFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.fragment_question, container, false);

    submitButton = (Button) view.findViewById(R.id.submitButtonf);
    submitButton.setVisibility(View.INVISIBLE);
    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });

    choices = (RadioGroup) view.findViewById(R.id.choicesf);
    choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {
        submitButton.setVisibility(View.VISIBLE);
        // Gets the id of the RadioButton selected
        int id = choices.getCheckedRadioButtonId();
        // Gets the actual radio button that is clicked (so we can grab text)
        RadioButton rb = (RadioButton) view.findViewById(id);
      }
    });

    return view;
  }

}
