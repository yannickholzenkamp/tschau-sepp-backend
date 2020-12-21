package me.holzenkamp.games.tschausepp.business.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StackOfCards {

    private List<Card> cards = new ArrayList<>();
    private List<Card> discarded = new ArrayList<>();

    public void setUpStack() {
        cards = generateDeck();
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            if (!discarded.isEmpty()) {
                cards = discarded;
                discarded = new ArrayList<>();
                Collections.shuffle(cards);
            } else {
                cards = generateDeck();
                Collections.shuffle(cards);
            }
        }
        return cards.remove(0);
    }

    public void put(Card card) {
        discarded.add(card);
    }

    private List<Card> generateDeck() {
        List<Card> cards = new ArrayList<>();
        for (CardType type : CardType.values()) {
            for (CardNumber number : CardNumber.values()) {
                cards.add(Card.builder().type(type).number(number).build());
            }
        }
        return cards;
    }

}
