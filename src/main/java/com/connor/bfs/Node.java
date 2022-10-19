package com.connor.bfs;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public T val;

    public Node(T value){
        this(value, null, null);
    }

    public Node(T value, Node<T> leftNode, Node<T> rightNode){
        val = value;
        left = leftNode;
        right = rightNode;
    }
}