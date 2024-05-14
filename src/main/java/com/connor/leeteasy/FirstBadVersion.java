package com.connor.leeteasy;

public class FirstBadVersion {

    int badVersion;

    public FirstBadVersion(int bad){
        badVersion = bad;
    }

    public int firstBadVersion(int n) {
        int start = 1, end = n, firstBadVersionGuess = 0;
        while(end - start > 1){
            firstBadVersionGuess = ((end - start)/2) + start;
            if(isBadVersion(firstBadVersionGuess)){
                end = firstBadVersionGuess;
            } else {
                start = firstBadVersionGuess;
            }
        }
        return isBadVersion(start) ? start : end;
    }

    private boolean isBadVersion(int n){
        return n >= badVersion;
    }
}
