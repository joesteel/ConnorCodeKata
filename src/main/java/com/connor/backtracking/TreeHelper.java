package com.connor.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class TreeHelper {
    private TreeHelper(){};
    public static <T> String serializeTree(Node<T> node, Function<T, String> f ){
        // add my own value to the string, then add the size of my child list
        // then apply the same function to each of my children
        StringBuilder serializedTree = new StringBuilder();
        serializedTree.append(f.apply(node.val) + " ");
        int numChildren = (node.children == null) ? 0:node.children.size();
        serializedTree.append(numChildren + " ");
        for(int i = 0; i < numChildren; i++){
            serializedTree.append(serializeTree(node.children.get(i), f));
        }
        return serializedTree.toString();
    }

    public static <T> Node<T> deserializeTree(Iterator<String> itr, Function<String,T> f){
        // For each string in the itr, I need to create a node from it
        // Then grab the next element and use that to create the children
        // So we can do this with a pre-order traversal of the tree
        Node<T> node = null;
        if(itr.hasNext()){
            node = new Node<T>(f.apply(itr.next()));
            node.children = new ArrayList<>();
            int numChildNodesToProcess = Integer.parseInt(itr.next()); // assuming this is present
            while (numChildNodesToProcess > 0) {
                Node<T> child = deserializeTree(itr, f);
                node.children.add(child);
                numChildNodesToProcess--;
            }
        }
        return node;
    }
}
