package com.task.rockpaperscissors.service;

import com.task.rockpaperscissors.dto.Round;
import com.task.rockpaperscissors.dto.Total;

public interface RoundService {

    Round playRound();

    Total getTotal();

    void deleteTotal();

}
