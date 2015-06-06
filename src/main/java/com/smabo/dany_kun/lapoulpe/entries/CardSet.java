package com.smabo.dany_kun.lapoulpe.entries;

import com.smabo.dany_kun.lapoulpe.R;
import com.smabo.dany_kun.lapoulpe.entries.model.CardStatus;

/**
 * Created by dany on 06/06/15.
 */
public enum CardSet implements CardStatus<BooleanStateCard> {

    OCTOPUS_1(new OctopusCard(R.drawable.octopus_1)),
    WRONG_OCTOPUS_1(new WrongBooleanStatedCard(R.string.squid, R.drawable.squid_1));

    BooleanStateCard card;
    boolean status = false;

    CardSet(BooleanStateCard card) {
        this.card = card;
    }

    @Override
    public void setAlreadyAsked(boolean alreadyAsked) {
        this.status = alreadyAsked;
    }

    @Override
    public BooleanStateCard getCard() {
        return card;
    }

    @Override
    public boolean isAlreadyAsked() {
        return status;
    }

    public static void reset() {
        for (CardSet cardSet : values()) {
            cardSet.setAlreadyAsked(false);
        }
    }
}
