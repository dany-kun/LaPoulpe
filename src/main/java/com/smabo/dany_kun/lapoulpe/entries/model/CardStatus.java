package com.smabo.dany_kun.lapoulpe.entries.model;

/**
 * Created by dany on 06/06/15.
 */
public interface CardStatus<T extends Card> {

    boolean isAlreadyAsked();

    void setAlreadyAsked(boolean alreadyAsked);

    T getCard();

}
