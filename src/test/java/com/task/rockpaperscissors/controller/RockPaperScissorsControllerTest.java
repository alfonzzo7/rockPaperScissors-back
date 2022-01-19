package com.task.rockpaperscissors.controller;

import com.task.rockpaperscissors.dto.Choice;
import com.task.rockpaperscissors.dto.Round;
import com.task.rockpaperscissors.dto.Total;
import com.task.rockpaperscissors.service.RoundService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RockPaperScissorsController.class)
@AutoConfigureMockMvc
public class RockPaperScissorsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoundService roundService;

    @Test
    public void whenPostRound_thenPlayer1Wins() throws Exception {
        Round round = new Round(Choice.STONE, Choice.SCISSORS, "player 1 wins");
        given(roundService.playRound()).willReturn(round);

        mockMvc.perform(post("/api/v1/rounds"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.player1", Is.is(Choice.STONE.name())))
                .andExpect(jsonPath("$.player2", Is.is(Choice.SCISSORS.name())))
                .andExpect(jsonPath("$.result", Is.is("player 1 wins")));
    }

    @Test
    public void whenGetRound_thenTotalRoundsOne() throws Exception {
        Total total = new Total(1, 1, 0, 0);
        given(roundService.getTotal()).willReturn(total);

        mockMvc.perform(get("/api/v1/rounds"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rounds", Is.is(1)));
    }

    @Test
    public void whenDeleteRound_thenOk() throws Exception {
        mockMvc.perform(delete("/api/v1/rounds"))
                .andExpect(status().isOk());
    }

}
