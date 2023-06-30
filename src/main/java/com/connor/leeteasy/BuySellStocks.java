package com.connor.leeteasy;

public class BuySellStocks {

    public static int maxProfit(int[] prices) {
        int window = 0, ptr = 0, windowStart = 0, windowEnd = 0;
        while(ptr < prices.length){
            if(prices[ptr] < prices[windowStart]) {
                if(windowEnd > windowStart) window = Math.max(window, prices[windowEnd] - prices[windowStart]);
                windowStart = ptr;
                windowEnd = windowStart;
            }
            if(prices[ptr] > prices[windowEnd]) windowEnd = ptr;
            ptr++;
        }
        window = Math.max(window, prices[windowEnd] - prices[windowStart]);
        return window;
    }
}
