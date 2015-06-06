package com.smabo.dany_kun.lapoulpe.entries.model;

import android.support.annotation.Nullable;

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
        List<CardStatus<T>> cardsList = Arrays.asList(cardStatus);
        Iterator<CardStatus<T>> it = cardsList.iterator();

        while (it.hasNext()) {
            if (it.next().isAlreadyAsked()) it.remove();
        }

        if (cardsList.size() == 0) return null;

        return cardsList.get(r.nextInt(cardsList.size()));
    }

}
