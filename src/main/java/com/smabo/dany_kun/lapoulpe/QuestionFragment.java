package com.smabo.dany_kun.lapoulpe;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smabo.dany_kun.lapoulpe.views.QuizzCardView;

import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectViews;
import butterknife.OnClick;

public class QuestionFragment extends Fragment {

    private static final String QUESTION_FRAGMENT_CORRECT_IMG_RES_KEY = "com.smabo.dany_kun.lapoulpe.QUESTION_FRAGMENT_CORRECT_IMG_RES_KEY";
    private static final String QUESTION_FRAGMENT_WRONG_IMG_RES_KEY = "com.smabo.dany_kun.lapoulpe.QUESTION_FRAGMENT_WRONG_IMG_RES_KEY";

    private OnQuizzFragmentInteractionListener mListener;

    @InjectViews({R.id.image_quizz_left, R.id.image_quizz_right})
    List<QuizzCardView> quizzCards;

    private final int correctImgIndex = new Random().nextInt(1);


    public static QuestionFragment newInstance(@DrawableRes int correctImgRes, @DrawableRes int wrongImgRes) {
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(QUESTION_FRAGMENT_CORRECT_IMG_RES_KEY, correctImgRes);
        bundle.putInt(QUESTION_FRAGMENT_WRONG_IMG_RES_KEY, wrongImgRes);
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    public QuestionFragment() {
        // Required empty public constructor
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

        int correctImg = getArguments().getInt(QUESTION_FRAGMENT_CORRECT_IMG_RES_KEY);
        int wrongImg = getArguments().getInt(QUESTION_FRAGMENT_WRONG_IMG_RES_KEY);

        QuizzCardView correctQuizzCard = quizzCards.get(correctImgIndex);
        correctQuizzCard.setIsCorrect(true);
        correctQuizzCard.setImageResource(correctImg);

        for (QuizzCardView quizzCardView : quizzCards) {
            if (!quizzCardView.equals(correctQuizzCard)) quizzCardView.setImageResource(wrongImg);
        }


    }

    @OnClick({R.id.image_quizz_left, R.id.image_quizz_right})
    public void onQuizzCardClicked(QuizzCardView quizzCardView) {
        onImageChosen(quizzCardView.isCorrect());
    }

    private void onImageChosen(boolean correct) {
        showResult(correct);
        if (mListener != null) {
            mListener.onImageChosen(correct);
        }
    }

    private void showResult(boolean correct) {
        ButterKnife.apply(quizzCards, new ButterKnife.Action<QuizzCardView>() {
            @Override
            public void apply(QuizzCardView view, int index) {
                view.showResult();
            }
        });
    }

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
    }

}
