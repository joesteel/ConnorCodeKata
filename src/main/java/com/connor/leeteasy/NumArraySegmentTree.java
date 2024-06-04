package com.connor.leeteasy;

public class NumArraySegmentTree {
    public static class SegmentTreeNode {
        int start;
        int end;
        int rangeSum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int left, int right){
            start = left;
            end = right;
        }
    }
    public SegmentTreeNode root;
    final private int[] nums;
    public NumArraySegmentTree(int[] nums) {
        this.nums = nums;
        root = buildSegmentTree(0, nums.length-1);
    }
    private SegmentTreeNode buildSegmentTree(int start, int end){
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end){
            node.rangeSum = nums[start];
            return node;
        }
        int mid = start + (end - start)/2;
        node.left = buildSegmentTree(start, mid);
        node.right = buildSegmentTree(mid+1, end);
        node.rangeSum = node.left.rangeSum + node.right.rangeSum;
        return node;
    }

    private int computeRangeSum(int start, int end, SegmentTreeNode node){
        if(node == null) return 0;
        if(end < node.start || start > node.end) return 0; // node interval does not contain range query
        if(node.start >= start && node.end <= end) return node.rangeSum; // node interval is included within range query
        return computeRangeSum(start, end, node.left) + computeRangeSum(start, end, node.right); // range query is included in node interval
        }

    public int sumRange(int left, int right) {
        return computeRangeSum(left, right, root);
    }

}
