package com.cp.task2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by user on 16.03.2015.
 */
public class CustomArrayList<E> implements CustomList<E> {

    public CustomArrayList(LocalDateTime date){
        deletionDate = date;
        itemArray = (E[])new Object[DEFAULT_CAPACITY];
    }

    private static final int DEFAULT_CAPACITY = 10;
    private int index = 0;

    private LocalDateTime deletionDate;
    private E[] itemArray;

    @Override
    public int size() {
        return 0;
    }

    public int indexOf(E element){
        return 0;
    }

    public int lastIndexOf(E element){
        return 0;
    }

    public boolean set(int index, E element){
        return false;
    }

    private void widen(){
        E[] tempArray = (E[]) new Object[itemArray.length];
        for (int i = 0 ; i < itemArray.length; i ++){
            tempArray[i] = itemArray[i];
        }
        itemArray = (E[]) new Object[tempArray.length + DEFAULT_CAPACITY];
        for (int i = 0; i < tempArray.length; i++){
            itemArray[i] = tempArray[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < itemArray.length; i ++){
            if (itemArray.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index > itemArray.length){
            throw new IndexOutOfBoundsException();
        }
        return itemArray[index];
    }

    @Override
    public boolean add(E element) {
        if (index == itemArray.length -1){
            widen();
        }
        itemArray[index] = element;
        index ++;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        while (index > itemArray.length){
            throw new IndexOutOfBoundsException();
        }

        E[] tempArray = (E[])new Object[itemArray.length +1];
        for (int i = 0; i < index; i ++){
            tempArray[i] = itemArray[i];
        }
        tempArray[index] = element;
        for(int i = index; i < itemArray.length; i++){
            tempArray[i +1] = itemArray[i];
        }
        itemArray = tempArray;
        new ArrayList<String>().add(100, "hello");
        index ++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    public boolean remove(int index){
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void setDeletionDate(LocalDateTime date) {
        deletionDate = date;
    }
}
