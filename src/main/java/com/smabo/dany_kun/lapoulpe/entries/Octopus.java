package com.smabo.dany_kun.lapoulpe.entries;

import com.smabo.dany_kun.lapoulpe.entries.model.CardStatus;

/**
 * Created by dany on 06/06/15.
 */
public enum Octopus implements CardStatus<BooleanStateCard> {
    OCTOPUS_1(CardSet.OCTOPUS_1),
    OCTOPUS_2(CardSet.OCTOPUS_2),
    OCTOPUS_3(CardSet.OCTOPUS_3),
    OCTOPUS_4(CardSet.OCTOPUS_4),
    OCTOPUS_5(CardSet.OCTOPUS_5),
    OCTOPUS_6(CardSet.OCTOPUS_6),
    OCTOPUS_7(CardSet.OCTOPUS_7),
    OCTOPUS_8(CardSet.OCTOPUS_8),
    OCTOPUS_9(CardSet.OCTOPUS_9),
    OCTOPUS_10(CardSet.OCTOPUS_10);

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
