package com.smabo.dany_kun.lapoulpe.entries;

import com.smabo.dany_kun.lapoulpe.R;
import com.smabo.dany_kun.lapoulpe.entries.model.CardStatus;

/**
 * Created by dany on 06/06/15.
 */
public enum CardSet implements CardStatus<BooleanStateCard> {

    OCTOPUS_1(new OctopusCard(R.drawable.octopus)),
    OCTOPUS_2(new OctopusCard(R.drawable.octopus2)),
    OCTOPUS_3(new OctopusCard(R.drawable.octopus3)),
    OCTOPUS_4(new OctopusCard(R.drawable.octopus4)),
    OCTOPUS_5(new OctopusCard(R.string.octopus_blue_ringed, R.drawable.octopus_blue_ringed)),
    OCTOPUS_6(new OctopusCard(R.string.octopus_briaerus, R.drawable.octopus_briareus)),
    OCTOPUS_7(new OctopusCard(R.string.octopus_pulpo_a_la_gallega, R.drawable.octopus_pulpo_a_la_gallega)),
    OCTOPUS_8(new OctopusCard(R.string.octopus_rubesscens, R.drawable.octopus_rubesscens)),
    OCTOPUS_9(new OctopusCard(R.string.octopus_salutii, R.drawable.octopus_salutii)),
    OCTOPUS_10(new OctopusCard(R.string.octopus_takoyaki, R.drawable.octopus_takoyaki)),
    N_OCTOPUS_1(new WrongBooleanStatedCard(R.string.bigfin_reef_squid, R.drawable.n_bigfin_reef_squid)),
    N_OCTOPUS_2(new WrongBooleanStatedCard(R.string.squid_baby, R.drawable.n_squid_baby)),
    N_OCTOPUS_3(new WrongBooleanStatedCard(R.string.cuttlefish, R.drawable.n_cuttlefish)),
    N_OCTOPUS_4(new WrongBooleanStatedCard(R.string.fried_squid, R.drawable.n_fried_squid)),
    N_OCTOPUS_5(new WrongBooleanStatedCard(R.string.squid, R.drawable.n_squid)),
    N_OCTOPUS_6(new WrongBooleanStatedCard(R.string.ika_sou_men, R.drawable.n_ika_sou_men)),
    N_OCTOPUS_7(new WrongBooleanStatedCard(R.string.ika_yaki, R.drawable.n_ika_yaki)),
    N_OCTOPUS_8(new WrongBooleanStatedCard(R.string.kraken, R.drawable.n_kraken)),
    N_OCTOPUS_9(new WrongBooleanStatedCard(R.string.long_tentacled_anemone, R.drawable.n_long_tentacled_anemone)),
    N_OCTOPUS_10(new WrongBooleanStatedCard(R.string.reef_cuttlefish, R.drawable.n_reef_cuttlefish));

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
