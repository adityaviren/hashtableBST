package com.cg.hashtable;

class HashMap<K,V> {

    LinkedList<K,V> linkedList;

    public HashMap(){
        linkedList=new LinkedList();
    }

    public V get(K key) {
        MapNode<K,V> mapNode = (MapNode<K, V>) linkedList.search(key);
        return (mapNode == null) ? null : mapNode.getValue();
    }

    public void add(K key, V value) {
        MapNode<K,V> mapNode = (MapNode<K, V>) linkedList.search(key);
        if(mapNode==null){
            mapNode = new MapNode<>(key,value);
            linkedList.append(mapNode);
        }
        else
            mapNode.setValue(value);
    }

    @Override
    public String toString() {
        return "HashNodes {"+ linkedList + "}";
    }
}

class MapNode<K,V> {
    K key;
    V value;
    MapNode next;

    public MapNode(K key, V value) {
        this.key=key;
        this.value=value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MapNode<K,V> getNext() {
        return next;
    }

    public void setNext(MapNode<K,V> next) {
        this.next = next;
    }

    public String toString(){
        StringBuilder myStringBuilder = new StringBuilder();
        myStringBuilder.append("{K = ").append(key).append(" V = ").append(value).append("}");
        if(next!=null)
            myStringBuilder.append("->");
        return myStringBuilder.toString();
    }
}

public class LinkedList<K,V> {
    private MapNode head = null;
    private MapNode tail = null;

    public void append(MapNode last) {

        MapNode node = head;
        tail = last;
        if (head == null) {
            head = last;
        } else {
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(last);
        }
    }

    public MapNode<K,V> search(K key) {
        MapNode temp = head;
        while (temp != null) {
            if (temp.getKey().equals(key)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
    public void delete(K key) {
        MapNode tempNode = head;
        while (tempNode != null) {
            if(head.getKey().equals(key)){
                if(head.getNext()==null){
                    head=null;
                    tail=null;
                    break;
                }
                else{
                    head=head.getNext();
                    break;
                }
            }
            if (tempNode.getNext().getKey().equals(key)) {
                tempNode.setNext(tempNode.getNext().getNext());
            }
            tail = tempNode;
            tempNode = tempNode.getNext();
        }
    }

    public void printLinkedList() {
        MapNode node = head;
        while (node != null) {
            System.out.print(node);
            if (node != tail) {
                System.out.print(" -> ");
            }
            node = node.getNext();
        }
    }
}
