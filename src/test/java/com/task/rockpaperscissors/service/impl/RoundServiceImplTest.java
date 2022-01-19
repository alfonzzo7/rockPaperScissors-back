package com.task.rockpaperscissors.service.impl;

import com.task.rockpaperscissors.dto.Choice;
import com.task.rockpaperscissors.dto.Round;
import com.task.rockpaperscissors.dto.Total;
import com.task.rockpaperscissors.service.RoundService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class RoundServiceImplTest {

    @TestConfiguration
    static class ServiceImplTestContextConfiguration {

        @Bean
        public RoundService roundService() {
            return new RoundServiceImpl();
        }
    }

    @Autowired
    private RoundService roundService;

    @Test
    public void whenPlayRound_thenPlayer1ChooseStone() {
        Round round = roundService.playRound();
        assertEquals(round.getPlayer1(), Choice.STONE);
    }

    @Test
    public void whenGetTotal_thenTotalRoundsOne() {
        Total total = roundService.getTotal();
        assertEquals(total.getRounds(), 1);
    }

    @Test
    public void whenDeleteTotal_thenTotalRoundsZero() {
        roundService.deleteTotal();
        Total total = roundService.getTotal();
        assertEquals(total.getRounds(), 0);
    }

}
