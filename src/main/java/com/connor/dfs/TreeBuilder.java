package com.connor.dfs;


import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.function.Function;

public class TreeBuilder<T> {
    public TreeBuilder(){
    }

    public TreeNode buildTreeFromString(final String serialisedTree, Function<Character, T> f){
        return buildTreeFromString(serialisedTree, 0, f);
    }


    public TreeNode buildTreeFromString(final String serialisedTree, final int buildType, Function<Character, T> f){
        TreeNode<T> root = null;
        switch (buildType) {
            default:
                StringCharacterIterator itr = new StringCharacterIterator(serialisedTree);
                root = preOrderBuild(itr, f);
        }
        return root;
    }

    private TreeNode<T> preOrderBuild(StringCharacterIterator itr, Function<Character, T> f){
        char val = itr.current();
        itr.next();
        if (val == 'x' || val == CharacterIterator.DONE) return null;
        TreeNode<T> node = new TreeNode(f.apply(val));
        node.left = preOrderBuild(itr, f);
        node.right = preOrderBuild(itr, f);
        return node;
    }

 }
