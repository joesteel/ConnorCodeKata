package com.connor.bfs;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class BinaryTreeHelper {

    public static <T> String serializeTree(Node<T> root){
        return "";
    }

    public static <T> Node<T> deSerializeTree(Iterator<String> itr, Function<String, T> f) {
        if (itr.hasNext()) {
            String val = itr.next();
            if (!val.equals("x")) {
                Node<T> node = new Node<>(f.apply(val));
                node.left = deSerializeTree(itr, f);
                node.right = deSerializeTree(itr, f);
                return node;
            }
        }
        return null;
    }

}
