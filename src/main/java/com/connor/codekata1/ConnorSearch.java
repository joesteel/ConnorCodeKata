package com.connor.codekata1;

import java.util.*;

public class ConnorSearch {
    private static final int NOT_FOUND = -1;
    public static final int RECURSION = 1;
    public static final int LOOP = 2;


    public int binarySearch(List<Integer> listToSearch, int elementToFind, int algoType){
        if(listToSearch.size() <= 0) return NOT_FOUND;

        switch (algoType) {
            case LOOP :
                return doBinarySearchWithLoop(listToSearch, elementToFind);
            default:
                return doBinarySearchWithRecusion(listToSearch, elementToFind, 0, listToSearch.size()-1);

        }
    }

    private int doBinarySearchWithRecusion(List<Integer> listToSearch, int elementToFind, int start, int end){
        if(start > end) return NOT_FOUND;
        int mid_point = ((end - start)/2) + start;
        if (elementToFind == listToSearch.get(mid_point)) {
            return mid_point;
        }
        else if(end - start == 0) return NOT_FOUND;
        else if(elementToFind < listToSearch.get(mid_point)) {
            return doBinarySearchWithRecusion(listToSearch, elementToFind, start, mid_point - 1);
            }
        else {
            return doBinarySearchWithRecusion(listToSearch, elementToFind,mid_point+1, end);
        }
    }


    private int doBinarySearchWithLoop(List<Integer> listToSearch, int elementToFind) {
        int start = 0, end = listToSearch.size()-1;
        while(start <= end) {
            int mid_point = ((end - start) / 2) + start;
            if (elementToFind == listToSearch.get(mid_point)) return mid_point;
            else if (elementToFind < listToSearch.get(mid_point)) end = mid_point - 1;
            else if (elementToFind > listToSearch.get(mid_point)) start = mid_point + 1;
        }
        return NOT_FOUND;
    }
}
