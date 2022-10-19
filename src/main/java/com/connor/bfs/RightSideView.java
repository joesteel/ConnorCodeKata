package com.connor.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSideView {

    public static List<Integer> binaryTreeRightSideView(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        int nodesInLevel = 1;
        ArrayDeque<Node<Integer>> deque = new ArrayDeque();
        deque.add(root);
        while(!deque.isEmpty()){
            for(int i = 0; i<nodesInLevel; i++){
                Node<Integer> currentNode = deque.remove();
                if(i == nodesInLevel-1) result.add(currentNode.val);
                for(Node<Integer> child: Arrays.asList(currentNode.left, currentNode.right)){
                    if(child!=null){
                        deque.add(child);
                    }
                }
            }
            nodesInLevel = deque.size();
        }
        return result;
    }
}
