package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumCoinsTest {

    @Test
    void shouldReturnCorrectForOneCoin() {
        int amount = 1;
        List<Integer> coins = Arrays.asList(1);
        int result = NumCoins.coinChange(coins, amount);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnCorrectForTwoCoins() {
        int amount = 4;
        List<Integer> coins = Arrays.asList(4,1);
        int result = NumCoins.coinChange(coins, amount);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnCorrectForThreeCoins() {
        int amount = 11;
        List<Integer> coins = Arrays.asList(5,3,1);
        int result = NumCoins.coinChange(coins, amount);
        assertEquals(3, result);
    }

    @Test
    void shouldReturnNegativeForAmountWhichDesntDivide() {
        int amount = 11;
        List<Integer> coins = Arrays.asList(20);
        int result = NumCoins.coinChange(coins, amount);
        assertEquals(-1, result);
    }
}