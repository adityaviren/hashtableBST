package com.cg.hashtable;

class BinaryNode<K extends Comparable<K>> {
    K key;
    BinaryNode<K> leftNode;
    BinaryNode<K> rightNode;

    BinaryNode(K key){
        this.key=key;
        leftNode=null;
        rightNode=null;
    }
}

public class BinarySearchTree<K extends Comparable> {

    BinaryNode root=null;
    public void add(K key) {
        root=addRecursively(root,key);
    }

    private BinaryNode addRecursively(BinaryNode current, K key) {
        if(current==null)
            return new BinaryNode(key);
        int compare_result=key.compareTo(current.key);
        if(compare_result==0){
            return current;
        }
        else if(compare_result>0){
            current.rightNode=addRecursively(current.rightNode,key);
        }
        else{
            current.leftNode=addRecursively(current.leftNode,key);
        }
        return current;
    }

    public int getSize() {
        return getSizeRecursively(root);
    }

    private int getSizeRecursively(BinaryNode current) {
        return current == null ? 0 : 1 + getSizeRecursively(current.leftNode) + getSizeRecursively(current.rightNode);
    }

}
