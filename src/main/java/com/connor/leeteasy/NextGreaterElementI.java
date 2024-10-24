package com.connor.leeteasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElements = new int[nums2.length];
        int[] result = new int[nums1.length];
        nextGreaterElements[nums2.length - 1] = -1;
        Map<Integer, Integer> largestElementMap = new HashMap<>();
        for (int i = nums2.length - 2; i >= 0; i--) {
            // is the next number bigger? then it's the next greatest element
            if (nums2[i] < nums2[i + 1]) {
                nextGreaterElements[i] = nums2[i + 1];
                largestElementMap.put(nums2[i], nextGreaterElements[i]);
            }
            // is it smaller and has no greater element? then current has no greater element
            else if (nums2[i] >= nums2[i + 1] && nextGreaterElements[i + 1] == -1) nextGreaterElements[i] = -1;
                // the next number is smaller and it has a greater element...
            else if (nums2[i] >= nums2[i + 1] && nextGreaterElements[i + 1] != -1) {
                //  ok need to loop then and stop when we get a larger number or a smaller number with no next Greater
                for (int j = i + 1; j < nextGreaterElements.length; j++) {
                    if (nums2[j] <= nums2[i] && nextGreaterElements[j] == -1) {
                        nextGreaterElements[i] = -1;
                        break;
                    } else if (nextGreaterElements[j] > nums2[i]) {
                        nextGreaterElements[i] = nextGreaterElements[j];
                        largestElementMap.put(nums2[i], nextGreaterElements[i]);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nums1.length; i++)
            result[i] = largestElementMap.getOrDefault(nums1[i], -1);

        return result;
    }

    public static int[] nextGreaterElementUsingMonotonicStack(int[] nums1, int[] nums2) {
       Stack<Integer> mono_stack = new Stack<>();
       Map<Integer, Integer> map = new HashMap<>();
       int[] result = new int[nums1.length];

       // run through nums2
        for(int num: nums2){
            while(!mono_stack.isEmpty() && mono_stack.peek() < num){
                map.put(mono_stack.pop(), num);
            }
            mono_stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
