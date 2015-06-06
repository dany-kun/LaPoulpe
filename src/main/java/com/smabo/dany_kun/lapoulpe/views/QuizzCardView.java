package com.smabo.dany_kun.lapoulpe.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.smabo.dany_kun.lapoulpe.R;
import com.smabo.dany_kun.lapoulpe.entries.model.Card;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dany on 06/06/15.
 */
public class QuizzCardView extends FrameLayout {

    @InjectView(R.id.imageview_card)
    ImageView imageView;
    @InjectView(R.id.textview_card)
    TextView textView;

    private Card stateCard;

    public QuizzCardView(Context context) {
        super(context);
        init(context, null);
    }

    public QuizzCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attributeSet) {
        View v = inflate(context, R.layout.view_quizz_card, this);

        if (!isInEditMode())
            ButterKnife.inject(v);
    }

    public <T extends Card> void setStateCardData(T stateCard) {
        this.stateCard = stateCard;
        resetView();
    }

    private void resetView() {
        imageView.setImageResource(stateCard.getDrawable());
    }

    public void showText() {
        textView.setText(stateCard.getStringRes());
    }

    public Object getCardStatus() {
        return stateCard.getStatus();
    }
}
