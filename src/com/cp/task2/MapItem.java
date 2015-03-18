package com.cp.task2;

import java.time.LocalDateTime;

/**
 * Created by user on 19.03.2015.
 */
public class MapItem<K, V> {
    public MapItem(K key, V value){
        setValue(value);
        this.key = key;
        creationDateTime = LocalDateTime.now();
    }

    private final K key;
    private V value;
    private LocalDateTime creationDateTime;

    public K getKey(){
        return key;
    }

    public void setValue(V value){
        this.value = value;
    }

    public V getValue(){
        return value;
    }

    public LocalDateTime getCreationDateTime(){
        return creationDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapItem mapItem = (MapItem) o;

        if (!creationDateTime.equals(mapItem.creationDateTime)) return false;
        if (!key.equals(mapItem.key)) return false;
        if (!value.equals(mapItem.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + creationDateTime.hashCode();
        return result;
    }
}
