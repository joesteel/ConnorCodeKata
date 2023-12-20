package com.connor.leeteasy;

public class MergeSortedLists {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m-1, ptr2 = n-1, current = nums1.length-1;
        while(ptr1 >= 0 && ptr2 >=0){
            if(nums2[ptr2] >= nums1[ptr1]){
                nums1[current--] = nums2[ptr2--];
            } else {
                nums1[current--] = nums1[ptr1];
                nums1[ptr1--] = 0;
            }
        }
        while(ptr2 >= 0){
            nums1[current--] = nums2[ptr2--];
        }
    }
}
