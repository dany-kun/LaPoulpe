package com.smabo.dany_kun.lapoulpe;

import android.app.Activity;
import android.os.Bundle;

import com.smabo.dany_kun.lapoulpe.entries.CardSet;
import com.smabo.dany_kun.lapoulpe.entries.Octopus;
import com.smabo.dany_kun.lapoulpe.entries.BooleanStateCard;
import com.smabo.dany_kun.lapoulpe.entries.WrongOctopusCard;
import com.smabo.dany_kun.lapoulpe.entries.model.CardGenerator;
import com.smabo.dany_kun.lapoulpe.entries.model.CardStatus;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements
        QuestionFragmentBoolean.OnQuizzFragmentInteractionListener,
        LastFragment.LastFragmentInteraction {

    private int score = 0;
    private int topScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            showNextFragment();
    }

    private void showNextFragment() {
        CardStatus<BooleanStateCard> octopus = CardGenerator.getNotAskedCard(Octopus.values());
        CardStatus<BooleanStateCard> wrongCard = CardGenerator.getNotAskedCard(WrongOctopusCard.values());

        if (octopus == null || wrongCard == null) showLastFragment();
        else showNextQuestionFragment(octopus, wrongCard);

    }

    private void showNextQuestionFragment(CardStatus<BooleanStateCard> octopus, CardStatus<BooleanStateCard> wrongCard) {
        octopus.setAlreadyAsked(true);
        wrongCard.setAlreadyAsked(true);

        getFragmentManager().beginTransaction()
                .replace(R.id.activity_container,
                        QuestionFragment.newInstance(
                                new QuestionFragmentBoolean(),
                                new ArrayList<>(Arrays.asList(octopus.getCard(), wrongCard.getCard())))
                )
                .commit();
    }

    private void showLastFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.activity_container,
                        LastFragment.newInstance(score, topScore))
                .commit();
    }

    @Override
    public void onImageChosen(boolean correct) {
        topScore++;
        if (correct) score++;
    }

    @Override
    public void onGoToNext() {
        showNextFragment();
    }

    @Override
    public void onRestartClicked() {
        topScore = 0;
        score = 0;
        CardSet.reset();
        showNextFragment();
    }
}
