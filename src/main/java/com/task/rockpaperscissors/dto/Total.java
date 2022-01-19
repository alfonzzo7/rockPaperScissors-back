package com.task.rockpaperscissors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Total implements Serializable {

    private long rounds;
    private long player1Wins;
    private long player2Wins;
    private long draws;

}
