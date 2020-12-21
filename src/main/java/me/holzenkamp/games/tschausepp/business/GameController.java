package me.holzenkamp.games.tschausepp.business;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameController {

    Map<String, Match> matches = new HashMap<>();

    public String newMatch() {
        String gameId = newGameId();
        matches.put(gameId, new Match());
        return gameId;
    }

    public Match getMatch(String gameId) {
        return matches.get(gameId);
    }

    private String newGameId() {
        return "dummy";
        // FIXME
        /*
        String gameId = RandomStringUtils.randomAlphanumeric(10);
        if (matches.containsKey(gameId)) {
            return newGameId();
        }
        return gameId;
         */
    }

}
