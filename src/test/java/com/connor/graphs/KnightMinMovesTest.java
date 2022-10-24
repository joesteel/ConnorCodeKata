package com.connor.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightMinMovesTest {

    @Test
    void shouldReturnZeroWhenAlreadyAtTheTargetPos() {
        int x = 0, y = 0;
        assertEquals(0, KnightMinMoves.getKnightShortestPath(x,y));
    }

    @Test
    void shouldReturnAnswerWhen1MoveToTarget() {
        int x = -1, y = 4;
        assertEquals(1, KnightMinMoves.getKnightShortestPath(x,y));
    }

    @Test
    void shouldReturnAnswerWhen3Move2ToTarget() {
        int x = -3, y = 12;
        assertEquals(3, KnightMinMoves.getKnightShortestPath(x,y));
    }

    @Test
    void shouldBreakIfRunningForTooManyIterations() {
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        assertEquals(-1, KnightMinMoves.getKnightShortestPath(x,y));

    }

}