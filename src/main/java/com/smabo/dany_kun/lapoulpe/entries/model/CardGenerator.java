package com.smabo.dany_kun.lapoulpe.entries.model;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by dany on 06/06/15.
 */
public class CardGenerator {

    private final static Random r = new Random();

    @Nullable
    public static <T extends Card> CardStatus<T> getNotAskedCard(CardStatus<T>[] cardStatus) {
        ArrayList<CardStatus<T>> candidates = new ArrayList<>();

        for (CardStatus<T> cardStatus1 : cardStatus) {
            if (!cardStatus1.isAlreadyAsked()) candidates.add(cardStatus1);
        }

        if (candidates.size() == 0) return null;

        return candidates.get(r.nextInt(candidates.size()));
    }

}
