package com.connor.leeteasy;

public class BinaryTreeTilt {

    private static int running_tilt_sum;
    public static int findTilt(TreeNode root) {
        running_tilt_sum = 0;
        sumTreeAndUpdateTilt(root);
        return running_tilt_sum;
    }

    private static int sumTreeAndUpdateTilt(TreeNode node){
        if(node == null) return 0;

        int left_sum = sumTreeAndUpdateTilt(node.left);
        int right_sum = sumTreeAndUpdateTilt(node.right);
        int tilt = Math.abs(left_sum - right_sum);
        running_tilt_sum += tilt;

        return left_sum+right_sum+node.val;
    }
}
