package com.connor.leetmedium;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max_area = 0, max_available_area, l = 0, r = height.length-1;
        while(l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max_area = Math.max(max_area, area);
            max_available_area = Math.max(height[l], height[r]) * (r - l);
            if (max_available_area == max_area || height[l] == height[r]) {
                l++;
                r--;
                continue;
            }
            if (height[l] < height[r]) l++;
            else  r--;
        }
        return max_area;
    }

}
