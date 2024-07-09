package com.connor.leeteasy;

public class GuessNumber {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    int num;
    public GuessNumber(int num){
        this.num = num;
    }
    private int guess(int num){
        return Integer.compare(this.num, num);
    }
    public int guessNumber(int n) {
        if(guess(n) == 0) return n;
        if(guess(n) == 1) return binarySearch(n+1, Integer.MAX_VALUE);
        else return binarySearch(0, n-1);
    }

    private int binarySearch(int start, int end){
        int mid = start + (end - start)/2;
        if(guess(mid) == 0) return mid;
        else if (guess(mid) == 1) return binarySearch(mid+1, end);
        else return binarySearch(start, mid-1);
    }

}
