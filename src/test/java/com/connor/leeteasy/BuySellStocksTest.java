package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStocksTest {

    @Test
    void shouldReturn0WhenOnlyOneTradingDay() {
        int[] prices = new int[]{1};
        int result = BuySellStocks.maxProfit(prices);
        assertEquals(0, result);
    }

    @Test
    void shouldReturn10WhenTwoIncreasingTradingDays() {
        int[] prices = new int[]{1,10};
        int result = BuySellStocks.maxProfit(prices);
        assertEquals(9, result);
    }

    @Test
    void shouldReturnMaxProfitAfter2FlatAndOneIncreasingTradingDays() {
        int[] prices = new int[]{2,2,5};
        int result = BuySellStocks.maxProfit(prices);
        assertEquals(3, result);
    }

    @Test
    void shouldReturn0WhenAllDaysDecrease() {
        int[] prices = new int[]{10,9,8,7};
        int result = BuySellStocks.maxProfit(prices);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnMaxProfitWhenPriceVarianceIsHigh() {
        int[] prices = new int[]{0,2,1,100,5,20};
        int result = BuySellStocks.maxProfit(prices);
        assertEquals(100, result);
    }

    @Test
    void shouldReturnMaxProfitWhenPriceVarianceIsHigh2() {
        int[] prices = new int[]{2,1,4};
        int result = BuySellStocks.maxProfit(prices);
        assertEquals(3, result);
    }
}