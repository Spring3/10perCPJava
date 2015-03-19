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
    private int size = 0;

    public void setCleaningDate(LocalDateTime dateTime){
        cleaningDate = dateTime;
        clean();
    }

    public int size(){
        int result = 0;
        for (int i = 0; i < items.length; i++){
            if (items[i] == null){
                break;
            }
            result = i+1;
        }
        size = result;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public boolean containsValue(V value){
        if (size() == 0)
            return false;

        for (int i = 0; i < size; i++){
            if (items[i].getValue().equals(value))
                return true;
        }
        return false;
    }

    public V get(K key){
        if (size == 0)
            return null;
        for (int i = 0 ; i < size; i++){
            if (items[i].getKey().equals(key))
                return items[i].getValue();
        }
        return null;
    }

    public K getKey(V value){
        if (containsValue(value)){
            for (int i =0; i < size; i ++){
                if (items[i].getValue().equals(value))
                    return items[i].getKey();
            }
        }
        return null;
    }

    public V put(K key, V value){
        if (size == items.length){
            widen();
        }
        if (value == null)
        {
            return null;
        }
        if (!containsKey(key)) {
            items[size++] = new MapItem(key, value);
            return value;
        }
        else{
            return replace(key, value) == true ? get(key) : null;
        }
    }

    public V remove(K key){
        MapItem<K, V>[] tempItems = new MapItem[items.length-1];
        V result = null;
        int index = 0;
        if (containsKey(key)){
            for (int i = 0 ; i < size; i ++){
                if (items[i].getKey().equals(key))
                {
                    index = i;
                    result = items[i].getValue();
                    break;
                }
                tempItems[i] = items[i];
            }
            for (int i = index +1; i < size; i++){
                tempItems[index] = items[i];
                ++index;
            }
            items = tempItems;
            --size;
        }

        return result;
    }

    public void clear(){
        items = new MapItem[DEFAULT_CAPACITY];
        size();
    }

    private void clean(){
        int currentSize = size;
        while(currentSize > 0){
            if (items[currentSize - 1].getCreationDateTime().toLocalTime().isBefore(cleaningDate.toLocalTime())){
                remove(items[currentSize -1].getKey());
                currentSize --;
            }
        }

    }

    private void widen(){
        MapItem<K, V>[] tempArray = new MapItem[items.length + DEFAULT_CAPACITY];
        for (int i = 0 ; i < items.length; i ++){
            tempArray[i] = items[i];
        }
        items = tempArray;
    }

    public boolean replace(K key, V newValue){
        if (newValue == null){
            return false;
        }
        if (containsKey(key)){
            for (int i = 0 ; i < size; i ++){
                if (items[i].getKey().equals(key)){
                    items[i].setValue(newValue);
                    return true;
                }
            }
        }
        return false;
    }
}
