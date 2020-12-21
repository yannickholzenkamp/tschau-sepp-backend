package me.holzenkamp.games.tschausepp.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {

    @GetMapping("/api/create")
    public GameMetaDto createGame() {
        return GameMetaDto.builder().id("hello").build();
    }

}
