package com.connor.codekata1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RackTest {

    @Test
    public void shouldAddABall(){
        Rack rack = new Rack();
        rack.add(20);
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(20);
        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }

    @Test
    public void shouldHandleDuplicates(){
        Rack rack = new Rack();
        rack.add(20);
        rack.add(20);
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(20);
        expectedResult.add(20);
        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }

    @Test
    public void shouldInsertSmallestBallAtTheStart(){
        Rack rack = new Rack();
        rack.add(20);
        rack.add(10);
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(10);
        expectedResult.add(20);
        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }

    @Test
    public void shouldInsertLargestBallAtTheEnd(){
        Rack rack = new Rack();
        rack.add(10);
        rack.add(20);
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(10);
        expectedResult.add(20);
        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }

    @Test
    public void shouldInsertABallIntoTheLeftSide(){
        Rack rack = new Rack();
        rack.add(30);
        rack.add(20);
        rack.add(10);
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(10);
        expectedResult.add(20);
        expectedResult.add(30);
        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }

    @Test
    public void shouldInsertABallIntoTheLeftWithARightTurn(){
        Rack rack = new Rack();
        rack.add(30);
        rack.add(20);
        rack.add(10);
        rack.add(15);
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(10);
        expectedResult.add(15);
        expectedResult.add(20);
        expectedResult.add(30);
        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }




    @Test
    public void shouldInsertABallIntoTheRightSide(){
        Rack rack = new Rack();
        rack.add(20);
        rack.add(30);
        rack.add(40);

        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(20);
        expectedResult.add(30);
        expectedResult.add(40);

        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }


    @Test
    public void shouldInsertABallIntoTheRightSideWithALeftTurn(){
        Rack rack = new Rack();
        rack.add(20);
        rack.add(30);
        rack.add(40);
        rack.add(35);

        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(20);
        expectedResult.add(30);
        expectedResult.add(35);
        expectedResult.add(40);

        assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
    }


    @Test
    public void shouldInsertlotsAndLotsOfBalls(){
        {
            Rack rack = new Rack();
            ArrayList<Integer> expectedResult = new ArrayList<Integer>();

            Random rand = new Random();
            int upperbound = 1000000;

            for(int i = 0; i < 60; i++)
            {
                int x = rand.nextInt(upperbound);
                rack.add(x);
                expectedResult.add(x);
            }
            Collections.sort(expectedResult);
            assertArrayEquals(expectedResult.toArray(), rack.balls.toArray());
        }
    }


    @Test
    public void shouldBeFast(){
        Rack rack = new Rack();
        ArrayList<Integer> expectedResult = new ArrayList<Integer>();

        Random rand = new Random();
        int upperbound = 1000000;

        for(int i = 0; i < 59; i++)
        {
            int x = rand.nextInt(upperbound);
            rack.add(x);
            expectedResult.add(x);
        }

        long addToRackStart = System.currentTimeMillis();
        rack.add(35);
        long addToRackend = System.currentTimeMillis();
        long rackTime = addToRackend - addToRackStart;
        System.out.println("Rack Time: " + rackTime);


        long fullSortTimeStart = System.currentTimeMillis();
        expectedResult.add(35);
        Collections.sort(expectedResult);
        long fullSortTimeEnd = System.currentTimeMillis();
        long addAndSortTime = fullSortTimeEnd - fullSortTimeStart;
        System.out.println("Add and Sort Time: " + addAndSortTime);


        assert(rackTime <= addAndSortTime);
    }

}