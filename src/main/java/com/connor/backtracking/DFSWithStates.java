package com.connor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSWithStates {

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        List<String> paths = new ArrayList<>();
        List<String> pathtoHere = new ArrayList<>();
        if (root != null) capturePath(root, pathtoHere, paths);
        return paths;
    }

    public static void capturePath(Node<Integer> node, List<String> pathToHere, List<String> paths){
        pathToHere.add(Integer.toString(node.val));
        if(node.children == null || node.children.size() == 0) paths.add(String.join("->", pathToHere));
        else{
            for(Node child: node.children){
                if(child != null) capturePath(child, pathToHere, paths);
            }
        }
        pathToHere.remove(pathToHere.size()-1);
    }
}
