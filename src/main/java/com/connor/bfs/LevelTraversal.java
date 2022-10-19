package com.connor.bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelTraversal {

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<Integer>> paths = new ArrayList<>();
        bfs(root, paths);
        return paths;
    }

    public static void bfs(Node<Integer> root, List<List<Integer>> result){
        if(root == null) return;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        int nodesInThisLevel = 1;
        while(!deque.isEmpty()){
            List<Integer> levelVals = new ArrayList<>();
            for(int i = 0; i < nodesInThisLevel; i++){
                Node<Integer> node = deque.remove();
                levelVals.add(node.val);
                for(Node<Integer> child:Arrays.asList(node.left, node.right)){
                    if(child!=null){
                        deque.add(child);
                    }
                }
            }
            result.add(new ArrayList<>(levelVals));
            nodesInThisLevel = deque.size();
        }
    }
}
