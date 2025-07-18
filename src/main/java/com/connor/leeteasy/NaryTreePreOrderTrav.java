package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreOrderTrav {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfsPreOrder(root, result);
        return result;
    }

    public void dfsPreOrder(Node node, List<Integer> result){
        if(node == null) return;

        result.add(node.val);
        for(Node child: node.children){
            dfsPreOrder(child, result);
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfsPostOrder(root, result);
        return result;
    }

    public void dfsPostOrder(Node node, List<Integer> result){
        if(node == null) return;

        for(Node child: node.children){
            dfsPostOrder(child, result);
        }
        result.add(node.val);
    }
}
