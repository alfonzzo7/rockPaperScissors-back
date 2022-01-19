package com.task.rockpaperscissors.service.impl;

import com.task.rockpaperscissors.dto.Choice;
import com.task.rockpaperscissors.dto.Round;
import com.task.rockpaperscissors.dto.Total;
import com.task.rockpaperscissors.service.RoundService;
import org.jeasy.random.EasyRandom;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

    private Total total = new Total();

    @Override
    public Round playRound() {
        EasyRandom easyRandom = new EasyRandom();

        Choice player1 = Choice.STONE;
        Choice player2 = easyRandom.nextObject(Choice.class);

        total.setRounds(total.getRounds() + 1L);

        String result;
        if (player1.win.equals(player2.name())) {
            result = "player 1 wins";
            total.setPlayer1Wins(total.getPlayer1Wins() + 1L);
        } else if (player2.win.equals(player1.name())) {
            result = "player 2 wins";
            total.setPlayer2Wins(total.getPlayer2Wins() + 1L);
        } else {
            result = "draw";
            total.setDraws(total.getDraws() + 1L);
        }

        Round round = new Round(player1, player2, result);
        return round;
    }

    @Override
    public Total getTotal() {
        return total;
    }

    @Override
    public void deleteTotal() {
        total = new Total();
    }

}
