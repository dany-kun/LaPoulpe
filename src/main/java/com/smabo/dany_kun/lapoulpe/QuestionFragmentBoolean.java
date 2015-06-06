package com.smabo.dany_kun.lapoulpe;

import com.smabo.dany_kun.lapoulpe.entries.BooleanStateCard;
import com.smabo.dany_kun.lapoulpe.views.QuizzCardView;

import butterknife.ButterKnife;

public class QuestionFragmentBoolean extends QuestionFragment<Boolean, Boolean, BooleanStateCard> {

    public QuestionFragmentBoolean() {
        // Required empty public constructor
    }

    @Override
    protected void onCardChosen(QuizzCardView quizzCardView, Boolean cardStatus) {
        onImageChosen(cardStatus);
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
                view.showText();
            }
        });
    }

}
