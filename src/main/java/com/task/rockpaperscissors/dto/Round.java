package com.task.rockpaperscissors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Round implements Serializable {

    private Choice player1;
    private Choice player2;
    private String result;

}
