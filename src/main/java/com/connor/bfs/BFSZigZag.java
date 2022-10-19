package com.connor.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSZigZag {

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        int nodesInThisLevel = 1;
        boolean rightToLeft = false;
        while(!deque.isEmpty()){
            List<Integer> levelVals = new ArrayList<>();
            for(int i = 0; i < nodesInThisLevel; i++){
                Node<Integer> node = deque.remove();
                if(rightToLeft){
                    levelVals.add(0, node.val);
                } else levelVals.add(node.val);
                for(Node<Integer> child: Arrays.asList(node.left, node.right)){
                    if(child!=null){
                        deque.add(child);
                    }
                }
            }
            result.add(new ArrayList<>(levelVals));
            nodesInThisLevel = deque.size();
            rightToLeft = !rightToLeft;
        }
        return result;
    }
}
