package com.smabo.dany_kun.lapoulpe.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.Log;
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
    @InjectView(R.id.imageview_card_result)
    ImageView resultImageView;

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
        textView.setText(stateCard.getStringRes());
    }

    public void showText() {
        textView.setVisibility(VISIBLE);
    }

    public Object getCardStatus() {
        return stateCard.getStatus();
    }

    public void setResultImg(@DrawableRes int i) {
        resultImageView.setImageResource(i);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);

        ss.stateToSave = this.textView.getVisibility();
        BitmapDrawable bitmapDrawable = ((BitmapDrawable) resultImageView.getDrawable());
        if (bitmapDrawable != null)
            ss.resultBitmap = bitmapDrawable.getBitmap();
        return ss;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        int textVisibility = ss.stateToSave;
        Bitmap bitmap = ss.resultBitmap;

        //noinspection ResourceType
        textView.setVisibility(textVisibility);
        if (bitmap != null) resultImageView.setImageBitmap(bitmap);
    }

    static class SavedState extends BaseSavedState {
        int stateToSave;
        Bitmap resultBitmap;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.stateToSave = in.readInt();
            this.resultBitmap = in.readParcelable(getClass().getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.stateToSave);
            if (resultBitmap != null) out.writeParcelable(resultBitmap, flags);
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
