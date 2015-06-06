package com.smabo.dany_kun.lapoulpe;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
        implements QuestionFragment.OnQuizzFragmentInteractionListener {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .replace(R.id.activity_container, QuestionFragment.newInstance(R.drawable.octopus_1, R.drawable.squid_1))
                .commit();
    }

    @Override
    public void onImageChosen(boolean correct) {
        if (correct) score++;
    }

}
