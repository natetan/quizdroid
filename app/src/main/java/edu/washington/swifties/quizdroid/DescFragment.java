package edu.washington.swifties.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
public class DescFragment extends Fragment {
  private Button beginButton;
  private TextView descTextView;

  //private FragmentTransaction tx = getFragmentManager().beginTransaction();
  private Fragment display = null;


  public DescFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_desc, container, false);

    // Use this for data transfer
    String desc = getArguments().getString("DESC");

    beginButton = (Button) view.findViewById(R.id.beginButton);
    beginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Fragment next = new QuestionFragment();
        FragmentManager fm = getActivity().getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.fragment_placeholder, next);
        tx.addToBackStack(null);
        tx.commit();
      }
    });

    descTextView = (TextView) view.findViewById(R.id.descTextView);
    descTextView.setText(desc);
    return view;
  }
}
