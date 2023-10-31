package com.connor.sort;

import java.util.*;

public class ConnorSearch {
    public static final int NOT_FOUND = -1;
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

    public int findBoundary(boolean[] listToSearch){
        int start = 0, end = listToSearch.length-1;
        int boundaryIndex = NOT_FOUND;
        while(start <= end){
            int midPoint = (end - start)/2 + start;
            if(listToSearch[midPoint] == true){
                boundaryIndex = midPoint;
                end = midPoint-1;
            } else start = midPoint+1;
        }
        return boundaryIndex;
    }

    public int firstNotSmaller(List<Integer> arr, int target){
        int left = 0, right = arr.size()-1;
        while(left < right){
            int midPoint = left + (right - left)/2;
            if(arr.get(midPoint) >= target) right = midPoint;
            else if (arr.get(midPoint) < target) left = midPoint+1;
        }
        if (left == right && arr.get(left) >= target) return left;
        return NOT_FOUND;
    }


    public int findFirstOccurrence(List<Integer> arr, int target){
        int left = 0, right = arr.size()-1;
        int lowestMatch = NOT_FOUND;
        while(left <= right){
            int midPoint = left + (right-left)/2;
            if(arr.get(midPoint) == target) lowestMatch = midPoint;
            if(arr.get(midPoint) >= target) right = midPoint-1;
            else left = midPoint+1;
        }
        return lowestMatch;
    }

    public static int squareRoot(int n) {
        int left = 0, right = n;
        int closestSquareRoot = 0;
        while(left <= right){
            int midPoint = left + (right - left)/2;
            if(midPoint*midPoint <= n){
                closestSquareRoot = midPoint;
                left = midPoint+1;
            }
            else if(midPoint*midPoint > n) right = midPoint-1;
        }
        return closestSquareRoot;
    }

    public static int findMinRotated(List<Integer> arr) {
        int left = 0, right = arr.size()-1;
        int pivotPoint = 0;
        while(left <= right){
            int midPoint = left + (right - left)/2;
            if(arr.get(midPoint) <= arr.get(arr.size()-1)) {
                pivotPoint = midPoint;
                right = midPoint-1;
            }
            else if(arr.get(midPoint) > arr.get(arr.size()-1)) left = midPoint+1;
        }
        return pivotPoint;
    }

    public static int minMaxWeight(List<Integer> weights, int d) {
        int maxCapacity = weights.stream().reduce(0, (a, b) -> a + b);
        int left = 0, right = maxCapacity;
        int optimalTruckCapacity = 0;
        while(left <= right){
            int midPoint = left + (right - left)/2;
            if(numberOfDeliveriesRequired(midPoint, weights) <= d){
                optimalTruckCapacity = midPoint;
                right = midPoint-1;
            }
            else left = midPoint+1;
        }
        return optimalTruckCapacity;
    }

    public static int numberOfDeliveriesRequired(final int truckCapacity, final List<Integer> weights) {
        int deliveriesRequired = 0, currentBatch = 0;
        if (weights != null && weights.size() > 0) {
            deliveriesRequired = 1;
            for (int parcelId = 0; parcelId < weights.size(); parcelId++) {
                if (weights.get(parcelId) > truckCapacity) return Integer.MAX_VALUE;
                else if (weights.get(parcelId) + currentBatch <= truckCapacity) {
                    currentBatch += weights.get(parcelId);
                } else {
                    deliveriesRequired++;
                    currentBatch = weights.get(parcelId);
                }
            }
        }
        return deliveriesRequired;
    }

    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        int l_ptr = newspapersReadTimes.stream()
                .mapToInt(x->x)
                .max()
                .orElseThrow(NoSuchElementException::new);
        int r_ptr = newspapersReadTimes.stream().reduce(0, (a,b) -> (a+b));
        int optimalReadTime = r_ptr;
        while(l_ptr <= r_ptr){
            int readTimeGuess = l_ptr + (r_ptr - l_ptr)/2;
            if(papersCanBeReadInAllottedTime(newspapersReadTimes, numCoworkers, readTimeGuess)){
                optimalReadTime = readTimeGuess;
                r_ptr = readTimeGuess-1;
            }
            else l_ptr = readTimeGuess+1;
        }
        return optimalReadTime;
    }

    public static boolean papersCanBeReadInAllottedTime(final List<Integer> newspapersReadTimes, final int numPeople, final int allotedReadTime){
        int totalReadingSessions = 1;
        int timeSpentReadingForOnePerson = 0;
        for(int paperReadTime: newspapersReadTimes){
            if(timeSpentReadingForOnePerson + paperReadTime <= allotedReadTime){
                timeSpentReadingForOnePerson += paperReadTime;
            } else {
                totalReadingSessions++;
                timeSpentReadingForOnePerson = paperReadTime;
            }
        }
        return totalReadingSessions <= numPeople;
    }

}