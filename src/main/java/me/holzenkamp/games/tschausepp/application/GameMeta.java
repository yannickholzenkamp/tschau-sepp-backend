package me.holzenkamp.games.tschausepp.application;

import lombok.Builder;
import lombok.Value;
import me.holzenkamp.games.tschausepp.business.Player;

import java.util.List;

@Value
@Builder
public class GameMeta {
    private String id;
    private Integer playerId;
    private List<Player> players;
}
