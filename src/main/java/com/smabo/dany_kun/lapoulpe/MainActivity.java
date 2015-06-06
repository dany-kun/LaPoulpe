package com.smabo.dany_kun.lapoulpe;

import android.app.Activity;

public class MainActivity extends Activity
        implements QuestionFragment.OnQuizzFragmentInteractionListener {

    private int score = 0;


    @Override
    public void onImageChosen(boolean correct) {
        showResult(correct);
        if (correct) score++;
    }

    private void showResult(boolean correct) {

    }
}
