package com.connor.codekata1;

public class Fibonacci {

    public Fibonacci() {
    }


    int[] calculateFib(int n){

        int[] myResult = {0,0};
        if(n <= 2) {
            myResult[0] = 1;
            myResult[1] = 0;
            return  myResult;
        }

        int[] myChildResult = calculateFib(n-1);
        myResult[0] = myChildResult[0] + myChildResult[1];
        myResult[1] = myChildResult[0];

        System.out.println("Term " + n + " : "  + myResult[0]);
        return myResult;
    }

}
