package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ConnorSortTest {

    @Test
    void shouldSortWithInsertionSort() {
    ConnorSort sort = new ConnorSort();
    List<Integer> actual = sort.insertionSort(Arrays.asList(10, 2, 4, 5));
    List<Integer> expected = Arrays.asList(2,4,5,10);
    assert(actual.equals(expected));
    }


    @Test
    void shouldSortProperlyWithSelectionSort(){
        ConnorSort sort = new ConnorSort();
        List<Integer> actual = sort.selectionSort(Arrays.asList(5,3,1,2,4));
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        assert(actual.equals(expected));
    }

    @Test
    void shouldSortProperlyWithBubbleSort(){
        ConnorSort sort = new ConnorSort();
        List<Integer> actual = sort.bubbleSort(Arrays.asList(5,3,1,2,4));
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        assert(actual.equals(expected));
    }


    @Test
    void shouldMergeTwoSmallSubLists(){
        ConnorSort sort = new ConnorSort();
        List<Integer> actual = sort.mergeSortedSubLists(Arrays.asList(2,3), Arrays.asList(1));
        List<Integer> expected = Arrays.asList(1,2,3);
        assert(actual.equals(expected));
    }

    @Test
    void shouldMergeTwoCoterminusSubLists(){
        ConnorSort sort = new ConnorSort();
        List<Integer> actual = sort.mergeSortedSubLists(Arrays.asList(2,3), Arrays.asList(1,4));
        List<Integer> expected = Arrays.asList(1,2,3,4);
        assert(actual.equals(expected));
    }


    @Test
    void shouldMergeTwoSubLists(){
        ConnorSort sort = new ConnorSort();
        List<Integer> actual = sort.mergeSortedSubLists(Arrays.asList(2,3,20,30), Arrays.asList(1,5,10,100,101,102,103));
        List<Integer> expected = Arrays.asList(1,2,3,5,10,20,30,100,101,102,103);
        assert(actual.equals(expected));
    }

    @Test
    void shouldMergeSortASmallList(){
        ConnorSort sort = new ConnorSort();
        List<Integer> actual = sort.mergeSort(Arrays.asList(2,1));
        List<Integer> expected = Arrays.asList(1,2);
        assert(actual.equals(expected));
    }


    @Test
    void shouldMergeSortAMediumList(){
        ConnorSort sort = new ConnorSort();
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);
        List<Integer> unsorted = new ArrayList<Integer>(expected);
        for(int i = 0; i < expected.size()*expected.size(); i++){
                Collections.shuffle(unsorted);
                List<Integer> actual = sort.mergeSort(unsorted);
                assert(actual.equals(expected));
            }
    }


    @Test
    void shouldMergeSortADecentList(){
        ConnorSort sort = new ConnorSort();
        List<Integer> expected = new ArrayList<Integer>();
        for(int i = 0; i < 1000; i++ ){
            expected.add(i);
        }
        List<Integer> unsorted = new ArrayList<Integer>(expected);
        for(int i = 0; i < expected.size(); i++){
            Collections.shuffle(unsorted);
            List<Integer> actual = sort.mergeSort(unsorted);
            assert(actual.equals(expected));
        }
    }

    @Test
    void shouldPivotSortSmallList() {
        ConnorSort sort = new ConnorSort();
        List<Integer> expected = Arrays.asList(1,2);
        List<Integer> actual = sort.pivotSort(Arrays.asList(2,1));
        assert(actual.equals(expected));
    }

    @Test
    void shouldPivotSortASmallSortedList() {
        ConnorSort sort = new ConnorSort();
        List<Integer> expected = Arrays.asList(1,2);
        List<Integer> actual = sort.pivotSort(Arrays.asList(1,2));
        assert(actual.equals(expected));
    }


    @Test
    void testtest() {
        ConnorSort sort = new ConnorSort();
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        List<Integer> actual = sort.pivotSort(Arrays.asList(2,1,3,5,4));
        assert(actual.equals(expected));
    }

    @Test
    void shouldPivotSortAMediumList() {
        ConnorSort sort = new ConnorSort();
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        List<Integer> unsorted = new ArrayList<Integer>(expected);
        for(int i = 0; i < unsorted.size() * unsorted.size(); i++) {
            Collections.shuffle(unsorted);
            System.out.println(" Sorting with " + unsorted);
            List<Integer> result = sort.pivotSort(unsorted);
            if(!result.equals(expected)) System.out.println(" !!!!!! Failed with " + unsorted);
            assert(result.equals(expected));
        }
    }

}