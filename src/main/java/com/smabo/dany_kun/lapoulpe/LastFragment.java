package com.smabo.dany_kun.lapoulpe;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class LastFragment extends Fragment {

    private static final String SCORE_KEY = "com.smabo.dany_kun.lapoulpe.SCORE_KEY";
    private static final String TOP_SCORE_KEY = "com.smabo.dany_kun.lapoulpe.TOP_SCORE_KEY";

    public static LastFragment newInstance(int score, int topScore) {
        LastFragment lastFragment = new LastFragment();
        Bundle b = new Bundle();
        b.putInt(SCORE_KEY, score);
        b.putInt(TOP_SCORE_KEY, topScore);
        lastFragment.setArguments(b);
        return lastFragment;
    }

    @InjectView(R.id.textview_score)
    TextView scoreTextView;

    private LastFragmentInteraction listener;

    public LastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);

        int score = getArguments().getInt(SCORE_KEY);
        int topScore = getArguments().getInt(TOP_SCORE_KEY);

        scoreTextView.setText(score + "/" + topScore);

    }

    @OnClick(R.id.textview_restart)
    public void onRestartClicked() {
        if (listener != null)
            listener.onRestartClicked();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (LastFragmentInteraction) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement LastFragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface LastFragmentInteraction {
        void onRestartClicked();
    }
}
