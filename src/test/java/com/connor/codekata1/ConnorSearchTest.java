package com.connor.codekata1;

import org.junit.jupiter.api.Test;

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

    private int fn(int i){
       return (i*i) - 10;
    }
}