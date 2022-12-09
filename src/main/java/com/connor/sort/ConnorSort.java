package com.connor.sort;

import java.util.*;

public class ConnorSort {
    public List<Integer> insertionSort(List<Integer> unsortedList) {
        List<Integer> result = new ArrayList<Integer>(unsortedList);
        int i = 0, j = 0;
        for (; i < result.size(); i++) {
            j = i;
            while (j > 0) {
                if (result.get(j) < result.get(j - 1)) {
                    Collections.swap(result, j - 1, j);
                }
                j--;
            }
        }
        return result;
    }

    public List<Integer> selectionSort(List<Integer> unsortedList) {
        List<Integer> result = new ArrayList<Integer>(unsortedList);
        int i = 0, j, smallest_index = 0;
        for (; i < result.size(); i++) {
            j = i;
            while (j < result.size()) {
                smallest_index = (result.get(j) < result.get(smallest_index)) ? j : smallest_index;
                j++;
            }
            Collections.swap(result, i, smallest_index);
        }
        return result;
    }

    public List<Integer> bubbleSort(List<Integer> unsortedList) {
        List<Integer> result = new ArrayList<Integer>(unsortedList);
        for (int i = result.size() - 1; i >= 0; i--) {
            int j = 0, biggest_index = 0;
            while (j <= i) {
                if (result.get(j) > result.get(biggest_index)) biggest_index = j;
                j++;
            }
            Collections.swap(result, i, biggest_index);
        }
        return result;
    }

    public List<Integer> mergeSort(List<Integer> unsortedList){
        if(unsortedList.size() <= 1) return unsortedList;
        int mid_point = unsortedList.size()/2;
        List<Integer> left = mergeSort(unsortedList.subList(0,mid_point));
        List<Integer> right = mergeSort(unsortedList.subList(mid_point, unsortedList.size()));
        return mergeSortedSubLists(left, right);
    }

    public List<Integer> mergeSortedSubLists(List<Integer> l_list, List<Integer> r_list) {
        // assuming both input lists are sorted
        Integer[] merged_list = new Integer[l_list.size() + r_list.size()];
        int i = 0, l_p = 0, r_p = 0;
        while (i < merged_list.length) {
            if (l_p < l_list.size() && r_p < r_list.size()) {
                //  we still in bounds on both lists so merge em
                if (l_list.get(l_p) < r_list.get(r_p)) {
                    merged_list[i] = l_list.get(l_p++);
                } else {
                    merged_list[i] = r_list.get(r_p++);
                }
            }
            else if (r_p >= r_list.size()) // right list is all done so just add elements from left
                merged_list[i] = l_list.get(l_p++);
            else if (l_p >= l_list.size()) // left list is all done so blast through right
                merged_list[i] = r_list.get(r_p++);
            i++;
        }
        return Arrays.asList(merged_list);
    }


    public List<Integer> pivotSort(List<Integer> unsortedList){
        List<Integer> result = new ArrayList<Integer>(unsortedList);
        doPivotSort(result, 0, result.size()-1);
        return result;
    }

    public void doPivotSort(List<Integer> listToSort, int intervalStart, int intervalEnd){
        if(intervalEnd-intervalStart < 1) return;
        int l_p = intervalStart, r_p = intervalEnd-1, pivot_index = intervalEnd;
        int pivot = listToSort.get(pivot_index);
        while(l_p != r_p){
            if(listToSort.get(l_p) > pivot && listToSort.get(r_p) < pivot) Collections.swap(listToSort, l_p, r_p);
            if(listToSort.get(l_p) < pivot) l_p ++;
            else if(listToSort.get(r_p) > pivot && r_p > l_p) r_p --;
        }
        if(listToSort.get(l_p) >= pivot){
            Collections.swap(listToSort, l_p, intervalEnd);
            pivot_index = l_p;
        }
        doPivotSort(listToSort, intervalStart, pivot_index-1);
        doPivotSort(listToSort, pivot_index+1, intervalEnd);
    }
}