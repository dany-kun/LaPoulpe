package com.smabo.dany_kun.lapoulpe.entries;

import com.smabo.dany_kun.lapoulpe.entries.model.CardStatus;

/**
 * Created by dany on 06/06/15.
 */
public enum Octopus implements CardStatus<BooleanStateCard> {
    OCTOPUS_1(CardSet.OCTOPUS_1);

    final CardSet cardSet;

    Octopus(CardSet cardSet) {
        this.cardSet = cardSet;
    }

    @Override
    public boolean isAlreadyAsked() {
        return cardSet.isAlreadyAsked();
    }

    @Override
    public BooleanStateCard getCard() {
        return cardSet.getCard();
    }

    @Override
    public void setAlreadyAsked(boolean alreadyAsked) {
        cardSet.setAlreadyAsked(alreadyAsked);
    }
}
