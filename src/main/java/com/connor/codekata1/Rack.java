package com.connor.codekata1;

import java.util.ArrayList;

public class Rack {
    ArrayList<Integer> balls;
    boolean finsihed;

    Rack() {
        balls = new ArrayList<Integer>(60);
        finsihed = false;
    }

    public void add(int x){
        // every time we add we're inserting into an already sorted list
        // insert is going to cause a shift of all the elements... maybe quicker to use a linked list and then convert to an array
        // ideas
        if(balls.size() == 0)  balls.add(x);
        else {
            finsihed = false;
            partitionBallsThenInsert(x, 0, balls.size());
        }
    }

    public void bruteForceBalls(int x){
        // for loop through the array until we find x is > than value at i and x < value at i i+1
        // 60 operations max
    }

    public void partitionBallsThenInsert(int x, int segmentStart, int segmentEnd){
        // split the array in half, is it larger or smaller than the value at teh half way point?
        // repeat
        // think this will run through the list log2 60 = 6ish times worst case

        if(segmentEnd - segmentStart == 1) {
            if (x < balls.get(segmentStart)) {
                balls.add(segmentStart, x);
                finsihed = true;
            }
            else if (x >= balls.get(segmentStart)) {
                balls.add(segmentStart + 1, x);
                finsihed = true;
            }
            return;
        }

        // split this segment up and call itself again using the segment where the ball should go
        // how to get the right segmentStart and segmentEnd
        int partitionPoint = segmentStart + (segmentEnd-segmentStart)/2;
        int leftStart = segmentStart;
        int leftEnd = partitionPoint;
        if(!finsihed && x <= balls.get(partitionPoint)) partitionBallsThenInsert(x, leftStart, leftEnd);

        int rightStart = partitionPoint;
        int rightEnd = segmentEnd;
        if(!finsihed && x >= balls.get(partitionPoint)) partitionBallsThenInsert(x, rightStart, rightEnd);
    }

}
