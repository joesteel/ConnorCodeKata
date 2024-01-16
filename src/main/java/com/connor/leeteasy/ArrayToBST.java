package com.connor.leeteasy;

public class ArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return createTreeFromArray(nums, 0, nums.length-1);
    }

    private static TreeNode createTreeFromArray(int[] nums, int start, int end){
        if(start > end) return null;

        int mid = (end-start)/2 + start;
        TreeNode left_sub_tree = createTreeFromArray(nums, start, mid-1);
        TreeNode right_sub_tree = createTreeFromArray(nums, mid+1, end);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = left_sub_tree;
        node.right = right_sub_tree;
        return node;
    }
}
