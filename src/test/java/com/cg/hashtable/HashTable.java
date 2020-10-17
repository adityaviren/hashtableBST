package com.cg.hashtable;

import java.util.ArrayList;

public class HashTable<K,V> {

    private final int num_of_buckets;
    ArrayList<LinkedList> my_bucket_array;

    public HashTable(){
        this.num_of_buckets=10;
        this.my_bucket_array=new ArrayList<>(num_of_buckets);

        for(int i=0;i<10;i++){
            my_bucket_array.add(null);
        }
    }

    public V get(K key) {
        int index=this.getBucketIndex(key);
        LinkedList linkedList=this.my_bucket_array.get(index);
        if(linkedList==null)
            return null;
        MapNode<K,V> mapNode = (MapNode<K, V>) linkedList.search(key);
        return (mapNode == null) ? null : mapNode.getValue();
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index=hashCode % num_of_buckets;
        return index;
    }


    public void add(K key, V value) {
        int index=this.getBucketIndex(key);
        LinkedList linkedList=this.my_bucket_array.get(index);
        if(linkedList == null){
            linkedList = new LinkedList();
            this.my_bucket_array.set(index,linkedList);
        }

        MapNode<K,V> mapNode = (MapNode<K, V>) linkedList.search(key);
        if(mapNode==null){
            mapNode = new MapNode<>(key,value);
            linkedList.append(mapNode);
        }
        else
            mapNode.setValue(value);

    }

    public void remove(K key) {
        int index=this.getBucketIndex(key);
        LinkedList linkedList=this.my_bucket_array.get(index);
        linkedList.delete(key);
    }
}
