package com.cg.hashtable;

import org.junit.Assert;
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
}
