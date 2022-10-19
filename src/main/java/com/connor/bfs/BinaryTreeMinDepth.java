package com.connor.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BinaryTreeMinDepth {

    public static int binaryTreeMinDepth(Node<Integer> root) {
        int result = -1;
        ArrayDeque<Node<Integer>> deque = new ArrayDeque<>();
        deque.add(root);
        int nodesInThisLevel = 1;
        int depth = 0;
        while(!deque.isEmpty()){
            for(int i = 0; i < nodesInThisLevel; i++){
                Node<Integer> currentNode = deque.pop();
                if(currentNode.left == null && currentNode.right == null) return depth;
                for(Node<Integer> child: Arrays.asList(currentNode.left, currentNode.right)){
                    if(child!=null) deque.add(child);
                }
            }
            nodesInThisLevel = deque.size();
            depth++;
        }
        return result;
    }

}
