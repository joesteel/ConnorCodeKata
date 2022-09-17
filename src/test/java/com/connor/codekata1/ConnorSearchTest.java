package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ConnorSearchTest {

    @Test
    void shouldNotFindElementThatDoesntExist() {
        ConnorSearch search = new ConnorSearch();
        int result = search.binarySearch(Arrays.asList(), 10, ConnorSearch.RECURSION);
        assert(result == -1);
    }

    @Test
    void shouldFindElementThatDoesExistInTinyList() {
        ConnorSearch search = new ConnorSearch();
        int result = search.binarySearch(Arrays.asList(1), 1, ConnorSearch.RECURSION);
        assert(result == 0);
    }

    @Test
    void shouldFindElementThatDoesExist() {
        ConnorSearch search = new ConnorSearch();
        int result = search.binarySearch(Arrays.asList(1,2,3,4,5,6), 4, ConnorSearch.RECURSION);
        assert(result == 3);
    }

    @Test
    void shouldFindElementsThatDoExistInLargeArray(){
        ConnorSearch search = new ConnorSearch();
        List<Integer> listToSearch = new ArrayList<Integer>(1000);
        for(int i = 0; i < 1000; i++){
            listToSearch.add(i,  fn(i));
        }
        Random r = new Random();
        for(int i = 0; i < 100; i++) {
            int index = r.nextInt(listToSearch.size()-1 - 0) + 0;
            int element_to_find = fn(index);
            int result = search.binarySearch(listToSearch, element_to_find, ConnorSearch.RECURSION);
            assert (result == index);
        }
    }

    @Test
    void shouldNotFindElementThatDoesntExistUsingLoop() {
        ConnorSearch search = new ConnorSearch();
        int result = search.binarySearch(Arrays.asList(), 10, ConnorSearch.LOOP);
        assert(result == -1);
    }

    @Test
    void shouldFindElementThatDoesExistInTinyListUsingLoop() {
        ConnorSearch search = new ConnorSearch();
        int result = search.binarySearch(Arrays.asList(1), 1, ConnorSearch.LOOP);
        assert(result == 0);
    }


    @Test
    void shouldFindElementThatDoesExistUsingLoop() {
        ConnorSearch search = new ConnorSearch();
        int result = search.binarySearch(Arrays.asList(1,2,3,4,5,6), 4, ConnorSearch.LOOP);
        assert(result == 3);
    }

    @Test
    void shouldFindElementsThatDoExistInLargeArrayUsingLoop(){
        ConnorSearch search = new ConnorSearch();
        List<Integer> listToSearch = new ArrayList<Integer>(1000);
        for(int i = 0; i < 1000; i++){
            listToSearch.add(i,  fn(i));
        }
        Random r = new Random();
        for(int i = 0; i < 100; i++) {
            int index = r.nextInt(listToSearch.size()-1 - 0) + 0;
            int element_to_find = fn(index);
            int result = search.binarySearch(listToSearch, element_to_find, ConnorSearch.LOOP);
            assert (result == index);
        }
    }

    @Test
    void shouldFindTheBoundaryGenerally(){
        ConnorSearch search = new ConnorSearch();
        int arraySize = 1000;
        boolean[] arr = new boolean[arraySize];
        for(int testNumber = 0; testNumber < 100; testNumber++){
            Random r = new Random();
            int boundary = r.nextInt(arraySize-1);
            for(int i = 0; i < arraySize-1; i++){
                if(i < boundary) arr[i] = false;
                else arr[i] = true;
            }
            int actualResult = search.findBoundary(arr);
            assertEquals(boundary, actualResult);
        }
    }


    @Test
    void shouldDealWithBaseCase() {
        ConnorSearch cs = new ConnorSearch();
        boolean[] arr = new boolean[]{false, true};
        int expectedResult = 1;
        int actualResult = cs.findBoundary(arr);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldFindBoundaryWithOneTrueElementInArray() {
        ConnorSearch cs = new ConnorSearch();
        boolean[] arr = new boolean[]{true};
        int expectedResult = 0;
        int actualResult = cs.findBoundary(arr);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldFindBoundaryWithOneFalseElementInArray() {
        ConnorSearch cs = new ConnorSearch();
        boolean[] arr = new boolean[]{false};
        int expectedResult = ConnorSearch.NOT_FOUND;
        int actualResult = cs.findBoundary(arr);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void shouldFindBoundaryWithOnlyFalseElementsInArray() {
        ConnorSearch cs = new ConnorSearch();
        boolean[] arr = new boolean[]{false, false, false};
        int expectedResult = ConnorSearch.NOT_FOUND;
        int actualResult = cs.findBoundary(arr);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void shouldFindFirstElementNotSmallerThanTarget() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.firstNotSmaller(Arrays.asList(1,2,3,4,5,6), 4);
        assertEquals(3, result);
    }


    @Test
    void shouldFindFirstElementNotSmallerThanTargetWhenListHasOneElementAndTargetIsLarger() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.firstNotSmaller(Arrays.asList(1), 4);
        assertEquals(ConnorSearch.NOT_FOUND, result);
    }

    @Test
    void shouldFindFirstElementNotSmallerThanTargetWhenListHasOneElement() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.firstNotSmaller(Arrays.asList(6), 4);
        assertEquals(0, result);
    }

    @Test
    void shouldFindFirstElementNotSmallerThanTargetGenerally() {
        ConnorSearch cs = new ConnorSearch();
        Random r = new Random();
        int arraySize = 1000;
        int expectedResult = 0;
        int offset = 100;
        for(int testNumber = 0; testNumber < 1000; testNumber++){
            List<Integer> list = new ArrayList<Integer>(arraySize);
            for(int j = 0; j < arraySize; j++){
                list.add(j,j+offset);
            }
            int target = r.nextInt(offset+arraySize+offset);
            if(target < offset) expectedResult = 0;
            else if (target >= arraySize+offset) expectedResult = ConnorSearch.NOT_FOUND;
            else expectedResult = target-offset;
            assertEquals(expectedResult, cs.firstNotSmaller(list, target));
        }
    }
    @Test
    void shouldMatchInAnArrayWithOneElement() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findFirstOccurrence(Arrays.asList(1), 1);
        assertEquals(0, result);
    }
    @Test
    void shouldNotMatchInAnArrayWithOneElementWhereTargetDoesNotExist() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findFirstOccurrence(Arrays.asList(1), 9);
        assertEquals(ConnorSearch.NOT_FOUND, result);
    }
    @Test
    void shouldNotMatchInAnArrayWhereTargetIsFirstElement() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findFirstOccurrence(Arrays.asList(1,1,1,1,1,2,3,4,5,5,5,100), 1);
        assertEquals(0, result);
    }
    @Test
    void shouldNotMatchInAnArrayWhereTargetIsLastElement() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findFirstOccurrence(Arrays.asList(1,1,1,1,1,2,3,4,5,5,5,100), 100);
        assertEquals(11, result);
    }


    @Test
    void shouldFindNearestSquareRootBaseCase() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.squareRoot(16);
        assertEquals(4, result);
    }

    @Test
    void shouldFindNearestSquareRootEdgeCase() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.squareRoot(1);
        assertEquals(1, result);
    }

    @Test
    void shouldFindNearestSquareRootWhereRootIsNotAnInteger() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.squareRoot(8);
        assertEquals(2, result);
    }

    @Test
    void shouldFindNearestSquareRootGenerally() {
        ConnorSearch cs = new ConnorSearch();
        int totalTests = 1000;
        int upperBound = (int)Math.floor(Math.sqrt(Integer.MAX_VALUE));
        Random rand = new Random();
        for(int test = 0; test < totalTests; test++){
            int n = rand.nextInt(upperBound);
            int expectedResult = (int)Math.floor(Math.sqrt(n));
            int result = cs.squareRoot(n);
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void shouldFindMinRotatedBoundarySimple() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findMinRotated(Arrays.asList(2,3,4,1));
        assertEquals(3, result);
    }

    @Test
    void shouldFindMinRotatedBoundaryOneElementInList() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findMinRotated(Arrays.asList(1));
        assertEquals(0, result);
    }

    @Test
    void shouldFindMinRotatedBoundaryNoRotation() {
        ConnorSearch cs = new ConnorSearch();
        int result = cs.findMinRotated(Arrays.asList(1,2,3,4,5,6,7,8,9,10,10,10));
        assertEquals(0, result);
    }


    @Test
    void shouldCalculateNumberOfDeliveriesCorrectly() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> weights = Arrays.asList(1,2,3,4,5);
        assertEquals(3, cs.numberOfDeliveriesRequired(6, weights));
    }

    @Test
    void shouldCalculateNumberOfDeliveriesIfListEmpty() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> weights = new ArrayList<Integer>();
        assertEquals(0, cs.numberOfDeliveriesRequired(6, weights));
    }

    @Test
    void shouldErrorIfAParcelWeightIsLargerThanTruckCapacity() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> weights = Arrays.asList(1,2,3,4,5);
        assertEquals(Integer.MAX_VALUE, cs.numberOfDeliveriesRequired(1, weights));
    }


    @Test
    void shouldCalculateNumberOfDeliveriesCorrectlyForUnOrderedListOfWeights() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> weights = Arrays.asList(3, 2, 2, 4, 1, 4);
        assertEquals(3, cs.numberOfDeliveriesRequired(6, weights));
    }

    @Test
    void shouldFindCorrectMinTruckCapacityForASimpleOrderedParcelLoad() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> weights = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int days = 5;
        int expectedResult = 15;
        assertEquals(expectedResult, cs.minMaxWeight(weights, days));
    }

    @Test
    void shouldFindCorrectMinTruckCapacityForAnUnOrderedParcelLoad() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> weights = Arrays.asList(3, 2, 2, 4, 1, 4);
        int days = 3;
        int expectedResult = 6;
        assertEquals(expectedResult, cs.minMaxWeight(weights, days));
    }


    @Test
    void shouldCorrectlyDetermineIfPapersCanBeReadInTime() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList(10);
        assertTrue(cs.papersCanBeReadInAllottedTime(newspaperReadTimes,1,10));
    }

    @Test
    void shouldCorrectlyDetermineIfPapersCanNotBeReadInTime() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList(10);
        assertTrue(cs.papersCanBeReadInAllottedTime(newspaperReadTimes,1,5));
    }


    @Test
    void shouldCorrectlyDetermineIfPapersCanBeReadInTimeForMultiplePeople() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList(10,5,10,5);
        assertTrue(cs.papersCanBeReadInAllottedTime(newspaperReadTimes,2,20));
    }

    @Test
    void shouldCorrectlyDetermineIfEmptyPaperListCanBeRead() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList();
        assertTrue(cs.papersCanBeReadInAllottedTime(newspaperReadTimes,20,20));
    }

    @Test
    void shouldCorrectlyDeterminePapersCanNotBeReadByNoPeople() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList(10,5,10,5);
        assertFalse(cs.papersCanBeReadInAllottedTime(newspaperReadTimes,0,20));
    }

    @Test
    void shouldCorrectlyDeterminePapersCanNotBeRead() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList(7,2,5,10,8);
        assertFalse(cs.papersCanBeReadInAllottedTime(newspaperReadTimes,2,14));
    }

    @Test
    void shouldReturnOptimalNewspaperReadTime() {
        ConnorSearch cs = new ConnorSearch();
        List<Integer> newspaperReadTimes = Arrays.asList(7,2,5,10,8);
        int coWorkers = 2;
        assertEquals(18, cs.newspapersSplit(newspaperReadTimes, coWorkers));
    }

    private int fn(int i){
       return (i*i) - 10;
    }
}