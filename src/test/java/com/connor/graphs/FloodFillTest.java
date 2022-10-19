package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloodFillTest {

    @Test
    void shouldGetNeighbouringCoordinate() {
        List<FloodFill.Coordinate> result = FloodFill.getNeighbours(new FloodFill.Coordinate(0,0), 2, 2);
        assertTrue(result.get(0).x == 0 && result.get(0).y == 1);
        assertTrue(result.get(1).x == 1 && result.get(1).y == 0);
        assertTrue(result.size() == 2);
    }

    @Test
    void shouldGetNoNeighbouringCoordinateForMatrixOfSizeOne() {
        List<FloodFill.Coordinate> result = FloodFill.getNeighbours(new FloodFill.Coordinate(0,0), 0, 0);
        assertTrue(result.size() == 0);
    }

    @Test
    void shouldGetFourNeighbouringCoordinatesWhenNotBorderingMatrixEdges() {
        List<FloodFill.Coordinate> result = FloodFill.getNeighbours(new FloodFill.Coordinate(2,2), 4, 4);
        assertTrue(result.get(0).x == 2 && result.get(0).y == 1);
        assertTrue(result.get(1).x == 1 && result.get(1).y == 2);
        assertTrue(result.get(2).x == 2 && result.get(2).y == 3);
        assertTrue(result.get(3).x == 3 && result.get(3).y == 2);
        assertTrue(result.size() == 4);
    }

    @Test
    void shouldGetFourNeighbouringCoordinatesWhenBorderingRightBottomMatrixEdges() {
        List<FloodFill.Coordinate> result = FloodFill.getNeighbours(new FloodFill.Coordinate(2,2), 3, 3);
        assertTrue(result.get(0).x == 2 && result.get(0).y == 1);
        assertTrue(result.get(1).x == 1 && result.get(1).y == 2);
        assertTrue(result.size() == 2);
    }


    @Test
    void shouldFloodFill2x2ImageAllSameColor() {
        List<List<Integer>> image = new ArrayList<>();
        image.add(Arrays.asList(5, 5));
        image.add(Arrays.asList(5, 5));
        FloodFill.floodFill(0,0, 6, image);
        assertTrue(image.get(0).equals(Arrays.asList(6,6)));
        assertTrue(image.get(1).equals(Arrays.asList(6,6)));
    }

    @Test
    void shouldFloodFill2x2ImageHalfSameColorW() {
        List<List<Integer>> image = new ArrayList<>();
        image.add(Arrays.asList(5, 5));
        image.add(Arrays.asList(7, 7));
        FloodFill.floodFill(0,0, 6, image);
        assertTrue(image.get(0).containsAll(Arrays.asList(6,6)));
        assertTrue(image.get(1).containsAll(Arrays.asList(7,7)));
    }

    @Test
    void shouldFloodFill4x4ImageHalfSameColorW() {
        List<List<Integer>> image = new ArrayList<>();
        image.add(Arrays.asList(5, 5, 6, 8));
        image.add(Arrays.asList(1, 5, 6, 8));
        image.add(Arrays.asList(2, 5, 6, 8));
        image.add(Arrays.asList(4, 5, 6, 8));
        FloodFill.floodFill(0,0, -4, image);
        assertTrue(image.get(0).equals(Arrays.asList(-4, -4, 6, 8)));
        assertTrue(image.get(1).equals(Arrays.asList(1, -4, 6, 8)));
        assertTrue(image.get(2).equals(Arrays.asList(2, -4, 6, 8)));
        assertTrue(image.get(3).equals(Arrays.asList(4, -4, 6, 8)));
    }


}