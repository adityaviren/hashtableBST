package com.cg.hashtable;

import com.sun.source.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {


    @Test
    public void givenString_whenParsed_shouldReturnFrequency() {
        String str="To be or not to be";
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] words=str.toLowerCase().split(" ");
        for(String s:words){
            Integer value = hashMap.get(s);
            if(value==null)
                value=1;
            else
                value++;
            hashMap.add(s,value);
        }
        int frequency = hashMap.get("to");
        Assert.assertEquals(2,frequency);
    }

    @Test
    public void givenString_whenParsed_shouldReturnParanoidFrequency() {
        String str="Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        HashTable<String,Integer> hashtable=new HashTable<>();
        String[] words=str.toLowerCase().split(" ");
        for(String s:words){
            Integer value = hashtable.get(s);
            if(value==null)
                value=1;
            else
                value++;
            hashtable.add(s,value);
        }
        int frequency = hashtable.get("paranoid");
        Assert.assertEquals(3,frequency);
    }

    @Test
    public void givenString_whenRemovedAvoidable_shouldReturnAvoidableFrequency() {
        String str="avoidable";
        HashTable<String,Integer> hashtable=new HashTable<>();
        String[] words=str.toLowerCase().split(" ");
        for(String s:words){
            Integer value = hashtable.get(s);
            if(value==null)
                value=1;
            else
                value++;
            hashtable.add(s,value);
        }
        hashtable.remove("avoidable");
        Integer frequency = hashtable.get("avoidable");
        Assert.assertEquals(null,frequency);
    }

    @Test
    public void givenNodes_whenInitialize_shouldReturnBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(56);
        bst.add(30);
        bst.add(70);
        bst.add(40);
        bst.add(22);
        bst.add(11);
        bst.add(16);
        bst.add(3);
        bst.add(95);
        bst.add(60);
        bst.add(65);
        bst.add(63);
        bst.add(67);
        int size = bst.getSize();
        Assert.assertEquals(13,size);
    }

    BinarySearchTree bst;

    @Before
    public void initialize(){
        bst = new BinarySearchTree();
        bst.add(56);
        bst.add(30);
        bst.add(70);
        bst.add(40);
        bst.add(22);
        bst.add(11);
        bst.add(16);
        bst.add(3);
        bst.add(95);
        bst.add(60);
        bst.add(65);
        bst.add(63);
        bst.add(67);
    }
    @Test
    public void givenBinarySearchTree_whenSearched_shouldReturnPosition() {
        boolean present=bst.search(63);
        Assert.assertTrue(present);
    }
}
