package me.holzenkamp.games.tschausepp.business;

import me.holzenkamp.games.tschausepp.business.cards.Card;
import me.holzenkamp.games.tschausepp.business.cards.StackOfCards;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private static final int START_CARDS = 7;

    private final StackOfCards stackOfCards;
    private List<Player> players = new ArrayList<>();

    public Match() {
        this.stackOfCards = new StackOfCards();
        this.stackOfCards.setUpStack();
    }

    public Player joinMatch(String name) {
        Player player = Player.builder().id(players.size()).name(name).build();
        players.add(player);
        return player;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void startGame() {
        for (int i = 0; i < START_CARDS; i++) {
            for (Player player : players) {
                player.getCards().add(stackOfCards.draw());
            }
        }
    }

    public Card drawCard(int playerId) {
        Card card = stackOfCards.draw();
        players.get(playerId).getCards().add(card);
        return card;
    }

    public void putCard(int playerId, Card card) {
        boolean removed = players.get(playerId).getCards().remove(card);
        if (!removed) {
            throw new RuntimeException("card is not available");
        }
        stackOfCards.put(card);
    }
}
