package com.smabo.dany_kun.lapoulpe;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smabo.dany_kun.lapoulpe.entries.model.Card;
import com.smabo.dany_kun.lapoulpe.views.QuizzCardView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

public abstract class QuestionFragment<A, S, T extends Card<S>> extends Fragment {

    private static final String CARDS_KEY = "com.smabo.dany_kun.lapoulpe.CARDS_KEY";
    private static final String STATE_ANSWERED = "com.smabo.dany_kun.lapoulpe.STATE_ANSWERED";
    private static final String STATE_GO_TO_NEXT_VISIBILITY = "com.smabo.dany_kun.lapoulpe.STATE_GO_TO_NEXT_VISIBILITY";

    protected OnQuizzFragmentInteractionListener mListener;

    @InjectViews({R.id.image_quizz_left, R.id.image_quizz_right})
    List<QuizzCardView> quizzCards;
    @InjectView(R.id.imageview_go_to_next)
    View goToNextView;

    private boolean answered;

    public static <A, S, T extends Card<S>> QuestionFragment newInstance(QuestionFragment<A, S, T> questionFragment, ArrayList<T> cards) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(CARDS_KEY, cards);
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_ANSWERED, answered);
        outState.putInt(STATE_GO_TO_NEXT_VISIBILITY, goToNextView.getVisibility());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) answered = savedInstanceState.getBoolean(STATE_ANSWERED);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);


        ArrayList<T> cards = getArguments().getParcelableArrayList(CARDS_KEY);

        if (cards.size() != quizzCards.size())
            throw new IllegalArgumentException("Cards and views number are not matching");

        Collections.shuffle(cards);

        for (int j = 0; j < cards.size(); j++) {
            T card = cards.get(j);
            QuizzCardView cardView = quizzCards.get(j);
            cardView.setStateCardData(card);
        }

        if (savedInstanceState != null) //noinspection ResourceType
            goToNextView.setVisibility(savedInstanceState.getInt(STATE_GO_TO_NEXT_VISIBILITY, View.GONE));

    }

    @OnClick({R.id.image_quizz_left, R.id.image_quizz_right})
    public void onQuizzCardClicked(QuizzCardView quizzCardView) {
        if (!answered) {
            this.answered = true;
            goToNextView.setVisibility(View.VISIBLE);
            @SuppressWarnings("unchecked") S cardStatus = (S) quizzCardView.getCardStatus();
            onCardChosen(quizzCardView, cardStatus);
        }
    }

    @OnClick(R.id.imageview_go_to_next)
    public void goToNextClicked() {
        if (answered && mListener != null) mListener.onGoToNext();
    }

    protected abstract void onCardChosen(QuizzCardView quizzCardView, S cardStatus);

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnQuizzFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnQuizzFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnQuizzFragmentInteractionListener {
        void onImageChosen(boolean correct);

        void onGoToNext();
    }

}
