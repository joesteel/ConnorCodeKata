package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlidingPuzzleTest {


    @Test
    void shouldSwapDown() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,0,3));
        board.add(Arrays.asList(4,2,5));
        List<List<Integer>> result = SlidingPuzzle.swapDown(0,1, board);
        assertTrue(result.get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(result.get(1).equals(Arrays.asList(4,0,5)));
    }

    @Test
    void shouldNotSwapDownIfOnBottomRow() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(4,0,5));
        List<List<Integer>> result = SlidingPuzzle.swapDown(1, 1, board);
        assertTrue(result == null);
    }

    @Test
    void shouldSwapUp() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(0,4,5));
        List<List<Integer>> result = SlidingPuzzle.swapUp(1,0, board);
        assertTrue(result.get(0).equals(Arrays.asList(0,2,3)));
        assertTrue(result.get(1).equals(Arrays.asList(1,4,5)));
    }

    @Test
    void shouldNotSwapUpIfOnTopRow() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(0,2,3));
        board.add(Arrays.asList(1,4,5));
        List<List<Integer>> result = SlidingPuzzle.swapUp(0,0, board);
        assertTrue(result == null);
    }


    @Test
    void shouldSwapLeft() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(4,0,5));
        List<List<Integer>> result = SlidingPuzzle.swapLeft(1, 1, board);
        assertTrue(result.get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(result.get(1).equals(Arrays.asList(0,4,5)));
    }

    @Test
    void shouldNotSwapLeftIfOnLeftMostCol() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(0,4,5));
        List<List<Integer>> result = SlidingPuzzle.swapLeft(1, 0, board);
        assertTrue(result == null);
    }

    @Test
    void shouldSwapRight() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(0,1,3));
        board.add(Arrays.asList(4,2,5));
        List<List<Integer>> result = SlidingPuzzle.swapRight(0,0, board);
        assertTrue(result.get(0).equals(Arrays.asList(1,0,3)));
        assertTrue(result.get(1).equals(Arrays.asList(4,2,5)));
    }

    @Test
    void shouldNotSwapRightIfOnRightMostCol() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(4,5,0));
        List<List<Integer>> result = SlidingPuzzle.swapRight(1, 2, board);
        assertTrue(result == null);
    }

    @Test
    void shouldGetNeighboursForBoardWhen0InMiddlePosition() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,0,3));
        board.add(Arrays.asList(4,2,5));
        List<List<List<Integer>>> neighbours = SlidingPuzzle.getNeighbours(board);
        assertTrue(neighbours.get(0).get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(neighbours.get(0).get(1).equals(Arrays.asList(4,0,5)));
        assertTrue(neighbours.get(1).get(0).equals(Arrays.asList(0,1,3)));
        assertTrue(neighbours.get(1).get(1).equals(Arrays.asList(4,2,5)));
        assertTrue(neighbours.get(2).get(0).equals(Arrays.asList(1,3,0)));
        assertTrue(neighbours.get(2).get(1).equals(Arrays.asList(4,2,5)));
        assertEquals(3, neighbours.size());
    }

    @Test
    void shouldGetNeighboursForBoardWhen0IsOnLeftMostCol() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(0,4,5));
        List<List<List<Integer>>> neighbours = SlidingPuzzle.getNeighbours(board);
        assertTrue(neighbours.get(0).get(0).equals(Arrays.asList(0,2,3)));
        assertTrue(neighbours.get(0).get(1).equals(Arrays.asList(1,4,5)));
        assertTrue(neighbours.get(1).get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(neighbours.get(1).get(1).equals(Arrays.asList(4,0,5)));
        assertEquals(2, neighbours.size());
    }


    @Test
    void shouldGetNeighboursForBoardWhen0IsOnRightMostCol() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(4,5,0));
        List<List<List<Integer>>> neighbours = SlidingPuzzle.getNeighbours(board);
        assertTrue(neighbours.get(0).get(0).equals(Arrays.asList(1,2,0)));
        assertTrue(neighbours.get(0).get(1).equals(Arrays.asList(4,5,3)));
        assertTrue(neighbours.get(1).get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(neighbours.get(1).get(1).equals(Arrays.asList(4,0,5)));
        assertEquals(2, neighbours.size());
    }

    @Test
    void shouldSerializeBoard() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,2,3));
        board.add(Arrays.asList(4,5,0));
        int result = SlidingPuzzle.serializeBoard(board);
        assertEquals(123450,result);
    }

    @Test
    void shouldSerializeBoardWithZeroInFirstPos() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(0,2,3));
        board.add(Arrays.asList(1,4,5));
        int result = SlidingPuzzle.serializeBoard(board);
        assertEquals(23145,result);
    }

    @Test
    void shouldSerializeBoardWithZeroInMiddlePos() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1,0,3));
        board.add(Arrays.asList(4,2,5));
        int result = SlidingPuzzle.serializeBoard(board);
        assertEquals(103425,result);
    }

    @Test
    void shouldDeserializeBoardWithZeroInFirstPos() {
        int serializedBoard = 13425;
        List<List<Integer>> result = SlidingPuzzle.deserializeBoard(serializedBoard);
        assertTrue(result.get(0).equals(Arrays.asList(0,1,3)));
        assertTrue(result.get(1).equals(Arrays.asList(4,2,5)));
    }

    @Test
    void shouldDeserializeBoardWithZeroInLastPos() {
        int serializedBoard = 123450;
        List<List<Integer>> result = SlidingPuzzle.deserializeBoard(serializedBoard);
        assertTrue(result.get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(result.get(1).equals(Arrays.asList(4,5,0)));
    }

    @Test
    void shouldDeserializeBoardWithZeroInMiddlePos() {
        int serializedBoard = 123045;
        List<List<Integer>> result = SlidingPuzzle.deserializeBoard(serializedBoard);
        assertTrue(result.get(0).equals(Arrays.asList(1,2,3)));
        assertTrue(result.get(1).equals(Arrays.asList(0,4,5)));
    }


    @Test
    void shouldReturn0StepsForBoardStartingAtTargetPosition() {
        int serializedBoard = 123450;
        int result = SlidingPuzzle.numSteps(SlidingPuzzle.deserializeBoard(serializedBoard));
        assertEquals(0, result);
    }

    @Test
    void shouldReturn1StepForBoardOneHorizontalMoveAwayFromTarget() {
        int serializedBoard = 123405;
        int result = SlidingPuzzle.numSteps(SlidingPuzzle.deserializeBoard(serializedBoard));
        assertEquals(1, result);
    }

    @Test
    void shouldReturn1StepForBoardOneVerticalMoveAwayFromTarget() {
        int serializedBoard = 120453;
        int result = SlidingPuzzle.numSteps(SlidingPuzzle.deserializeBoard(serializedBoard));
        assertEquals(1, result);
    }

    @Test
    void shouldReturn1StepForBoardTwoHorizontalMoveAwayFromTarget() {
        int serializedBoard = 123045;
        int result = SlidingPuzzle.numSteps(SlidingPuzzle.deserializeBoard(serializedBoard));
        assertEquals(2, result);
    }

    @Test
    void shouldReturn1StepForBoardThreeMovesAwayFromTarget() {
        int serializedBoard = 23145;
        int result = SlidingPuzzle.numSteps(SlidingPuzzle.deserializeBoard(serializedBoard));
        assertEquals(3, result);
    }

    @Test
    void shouldReturn1StepForBoardFiveMovesAwayFromTarget() {
        int serializedBoard = 413205;
        int result = SlidingPuzzle.numSteps(SlidingPuzzle.deserializeBoard(serializedBoard));
        assertEquals(5, result);
    }
}