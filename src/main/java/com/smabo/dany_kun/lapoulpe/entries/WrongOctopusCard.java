package com.smabo.dany_kun.lapoulpe.entries;

import com.smabo.dany_kun.lapoulpe.entries.model.CardStatus;

/**
 * Created by dany on 06/06/15.
 */
public enum WrongOctopusCard implements CardStatus<BooleanStateCard> {
    N_OCTOPUS_1(CardSet.N_OCTOPUS_1),
    N_OCTOPUS_2(CardSet.N_OCTOPUS_2),
    N_OCTOPUS_3(CardSet.N_OCTOPUS_3),
    N_OCTOPUS_4(CardSet.N_OCTOPUS_4),
    N_OCTOPUS_5(CardSet.N_OCTOPUS_5),
    N_OCTOPUS_6(CardSet.N_OCTOPUS_6),
    N_OCTOPUS_7(CardSet.N_OCTOPUS_7),
    N_OCTOPUS_8(CardSet.N_OCTOPUS_8),
    N_OCTOPUS_9(CardSet.N_OCTOPUS_9),
    N_OCTOPUS_10(CardSet.N_OCTOPUS_10);

    final CardSet cardSet;

    WrongOctopusCard(CardSet cardSet) {
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

