package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeIITest {

    @Test
    void shouldReturn0WhenNoPossibleComboAvailable() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(10));
        int amount = 1;
        int result = CoinChangeII.coinGame(coins, amount, "Top Down");
        assertEquals(0, result);
    }

    @Test
    void shouldReturn1When1ComboAvailable() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(10));
        int amount = 10;
        int result = CoinChangeII.coinGame(coins, amount, "Top Down");
        assertEquals(1, result);
    }

    @Test
    void shouldReturn2When2ComboAvailable() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(5,2));
        int amount = 10;
        int result = CoinChangeII.coinGame(coins, amount, "Top Down");
        assertEquals(2, result);
    }

    @Test
    void shouldReturn3When3ComboAvailable() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(1,5));
        int amount = 10;
        int result = CoinChangeII.coinGame(coins, amount, "Top Down");
        assertEquals(3, result);
    }

    @Test
    void shouldReturn3WhenManyComboAvailable() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(1,2,5));
        int amount = 5;
        int result = CoinChangeII.coinGame(coins, amount, "Top Down");
        assertEquals(4, result);
    }

}