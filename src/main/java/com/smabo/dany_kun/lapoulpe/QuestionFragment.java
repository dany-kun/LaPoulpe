package com.smabo.dany_kun.lapoulpe;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class QuestionFragment extends Fragment {

    private static final String QUESTION_FRAGMENT_CORRECT_IMG_RES_KEY = "com.smabo.dany_kun.lapoulpe.QUESTION_FRAGMENT_CORRECT_IMG_RES_KEY";
    private static final String QUESTION_FRAGMENT_WRONG_IMG_RES_KEY = "com.smabo.dany_kun.lapoulpe.QUESTION_FRAGMENT_WRONG_IMG_RES_KEY";

    private OnFragmentInteractionListener mListener;

    @InjectView(R.id.image_quizz_left)
    ImageView leftImg;
    @InjectView(R.id.image_quizz_right)
    ImageView rightImg;

    private final boolean leftImgStatus = new Random().nextBoolean();

    public static QuestionFragment newInstance(int correctImgRes, int wrongImgRes) {
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
        leftImg.setImageResource(leftImgStatus ? correctImg : wrongImg);
        rightImg.setImageResource(leftImgStatus ? wrongImg : correctImg);
    }

    @OnClick(R.id.image_quizz_left)
    public void onLeftImageClicked() {
        onImageChosen(leftImgStatus);
    }

    @OnClick(R.id.image_quizz_right)
    public void onRightImageClicked() {
        onImageChosen(!leftImgStatus);
    }

    private void onImageChosen(boolean b) {
        if (mListener != null) {
            mListener.onImageChosen(b);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onImageChosen(boolean correct);
    }

}
