package com.task.rockpaperscissors.controller;

import com.task.rockpaperscissors.dto.Round;
import com.task.rockpaperscissors.dto.Total;
import com.task.rockpaperscissors.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RockPaperScissorsController {

    private final RoundService roundService;

    /**
     * Play a round
     * @return Round
     */
    @PostMapping(value = "/rounds", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Round postRound() {
        return roundService.playRound();
    }

    /**
     * Get total of rounds played
     * @return Total
     */
    @GetMapping(value = "/rounds", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Total getRound() {
        return roundService.getTotal();
    }

    /**
     * Delete total of rounds played
     */
    @DeleteMapping(value = "/rounds", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public void deleteRound() {
        roundService.deleteTotal();
    }

}
