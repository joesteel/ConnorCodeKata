package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeITest {

    private static final int BottomUp = 10;

    @Test
    void shouldReturnZeroCoinsUsedForZeroChange() {
        List<Integer> coins = new ArrayList<>();
        int amount = 0;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnNotFoundWhenNoCoinFits() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,3,5,6));
        int amount = 1;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(-1, result);
    }

    @Test
    void shouldReturnNotFoundWhenNoCoinFits_BO() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,3,5,6));
        int amount = 1;
        int result = CoinChangeI.coinChange(coins, amount, BottomUp);
        assertEquals(-1, result);
    }

    @Test
    void shouldReturn1CoinWhen1CoinFits() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,3,5,6,1));
        int amount = 1;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(1, result);
    }


    @Test
    void shouldReturn1CoinWhen1CoinFits_BO() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,3,5,6,1));
        int amount = 1;
        int result = CoinChangeI.coinChange(coins, amount, BottomUp);
        assertEquals(1, result);
    }

    @Test
    void shouldReturn2CoinWhen2DifferentCoinsFit() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,5,6,1));
        int amount = 3;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(2, result);
    }

    @Test
    void shouldReturn2CoinWhen2DifferentCoinsFit_BO() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,1));
        int amount = 3;
        int result = CoinChangeI.coinChange(coins, amount,BottomUp);
        assertEquals(2, result);
    }



    @Test
    void shouldReturn2CoinWhen2OfTheSameCoinsFit() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,5,6,1));
        int amount = 4;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(2, result);
    }

    @Test
    void shouldReturn2CoinWhen2OfTheSameCoinsFit_BO() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,5,6,1));
        int amount = 4;
        int result = CoinChangeI.coinChange(coins, amount, BottomUp);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnCorrectResultForComplexCase() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,5,6,1,8));
        int amount = 33;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(5, result);
    }

    @Test
    void shouldReturnCorrectResultForComplexCase_BO() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2,5,6,1,8));
        int amount = 33;
        int result = CoinChangeI.coinChange(coins, amount, BottomUp);
        assertEquals(5, result);
    }

    @Test
    void shouldReturnCorrectResultForComplexMemoCase() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2, 1, 5));
        int amount = 12;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(3, result);
    }

    @Test
    void shouldReturnCorrectResultForComplexMemoCase_BO() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2, 1, 5));
        int amount = 12;
        int result = CoinChangeI.coinChange(coins, amount, BottomUp);
        assertEquals(3, result);
    }

    @Test
    void shouldReturnCorrectResultForComplexComplexMemoCase() {

        List<Integer> coins = Arrays.stream("186 419 83 408".split(" "))
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
        int amount = 6249;
        int result = CoinChangeI.coinChange(coins, amount);
        assertEquals(20, result);
    }

    @Test
    void shouldReturnCorrectResultForComplexComplexMemoCase_BO() {
        List<Integer> coins = Arrays.stream("186 419 83 408".split(" "))
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
        int amount = 6249;
        int result = CoinChangeI.coinChange(coins, amount, BottomUp);
        assertEquals(20, result);
    }

}