package com.cp.task2;

import java.time.LocalDateTime;

/**
 * Created by user on 16.03.2015.
 */
public class CustomMap<K,V> {

    public CustomMap(LocalDateTime dateTime){
        cleaningDate = dateTime;
        items = new MapItem[DEFAULT_CAPACITY];
    }

    private LocalDateTime cleaningDate;
    private MapItem<K,V>[] items;
    private static final int DEFAULT_CAPACITY = 10;

    public void setCleaningDate(LocalDateTime dateTime){
        cleaningDate = dateTime;
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean containsKey(Object key){
        return false;
    }

    public boolean containsValue(Object value){
        return false;
    }

    public V get(K key){
        return null;
    }

    public V put(K key, V value){
        return null;
    }

    public V remove(K key){
        return null;
    }

    public void clear(){

    }

    private void clean(){

    }

    public boolean replace(K key, V oldValue, V newValue){
        return false;
    }
}
