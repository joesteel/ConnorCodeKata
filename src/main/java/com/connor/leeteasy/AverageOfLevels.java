package com.connor.leeteasy;

import java.util.*;

public class AverageOfLevels {
    public static List<Double> averageOfLevels(TreeNode root) {
        return averageOfLevels(root, true);
    }

    public static List<Double> averageOfLevels(TreeNode root, boolean dfs) {
        if(dfs) return averageOfLevelsDFS(root);
        else return averageOfLevelsBFS(root);
    }

    private static List<Double> averageOfLevelsDFS(TreeNode root) {
        HashMap<Integer, Long> sum_of_level_values = new HashMap<>();
        HashMap<Integer, Long> count_level_values = new HashMap<>();
        dfs(root, 0, sum_of_level_values, count_level_values);

        int level = 0;
        List<Double> result = new ArrayList<>();
        while(sum_of_level_values.get(level) != null){
            result.add((double)sum_of_level_values.get(level)/count_level_values.get(level));
            level++;
        }
        return result;
    }

    private static void dfs(TreeNode node, int level, HashMap<Integer, Long> sum_of_values, HashMap<Integer, Long> count_of_vals){
        if(node == null) return;

        sum_of_values.putIfAbsent(level, (long) 0);
        count_of_vals.putIfAbsent(level, (long) 0);
        sum_of_values.put(level, sum_of_values.get(level) + node.val);
        count_of_vals.put(level, count_of_vals.get(level)+1);

        dfs(node.left, level+1, sum_of_values, count_of_vals);
        dfs(node.right, level+1, sum_of_values, count_of_vals);
    }
    private static List<Double> averageOfLevelsBFS(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Double> result = new ArrayList<>();
        int level_count = 1;

        while(!q.isEmpty() && q.peek() != null){
            double level_sum = 0;
            for(int i = 0; i < level_count; i++){
               TreeNode node = q.poll();
               level_sum += node.val;
               if(node.left != null) q.add(node.left);
               if(node.right != null) q.add(node.right);
           }
           result.add(level_sum/level_count);
           level_count = q.size();
        }
        return result;
    }
}
