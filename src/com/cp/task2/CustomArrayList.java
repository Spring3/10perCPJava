package com.cp.task2;

import org.mockito.cglib.core.Local;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Created by user on 16.03.2015.
 */
public class CustomArrayList<E> implements CustomList<E> {

    @SuppressWarnings("unchecked")
    public CustomArrayList(LocalDateTime date){
        deletionDate = date;
        new ArrayList<String>();
        itemArray = new Object[DEFAULT_CAPACITY];
        itemCreationDates = new LocalDateTime[DEFAULT_CAPACITY];
    }

    private static final int DEFAULT_CAPACITY = 10;
    private LocalDateTime deletionDate;
    private Object[] itemArray;
    private LocalDateTime[] itemCreationDates;

    @Override
    public int size() {
        for (int i = 0; i < itemArray.length; i++){
            if (itemArray[i] == null){
                return i; //the count of size starts from 1, not 0
            }
        }
        return  itemArray.length +1;
    }

    public int indexOf(E element){
        for (int i = 0 ; i < itemArray.length; i ++){
            if (itemArray[i] != null){
                if (itemArray[i].equals(element))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element){
        E result = null;
        int index = 0;
        for (int i = 0; i < itemArray.length; i ++){
            if (itemArray[i] != null){
                if (itemArray[i].equals(element)) {
                    result = (E) itemArray[i];
                    index = i;
                }
            }
        }
        return result == null ? -1 : index;
    }

    public boolean set(int index, E element){
        if (index > itemArray.length -1 && index < 0){
            throw new IndexOutOfBoundsException();
        }
        itemArray[index] = element;
        itemCreationDates[index] = LocalDateTime.now();
        return true;
    }

    private void widen(){
        Object[] tempArray = new Object[itemArray.length];
        LocalDateTime[] tempDates = new LocalDateTime[itemArray.length];
        for (int i = 0 ; i < itemArray.length; i ++){
            tempArray[i] = itemArray[i];
            tempDates[i] = itemCreationDates[i];
        }
        itemArray = new Object[tempArray.length + DEFAULT_CAPACITY];
        itemCreationDates = new LocalDateTime[tempArray.length + DEFAULT_CAPACITY];
        for (int i = 0; i < tempArray.length; i++){
            itemArray[i] = tempArray[i];
            itemCreationDates[i] = tempDates[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < itemArray.length; i ++){
            if (itemArray[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (size() == 0 && index == 0){
            throw new IndexOutOfBoundsException();
        }
        else if (size() != 0 && index == 0){
            return (E)itemArray[index];
        }
        else if (index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return (E)itemArray[index];
    }

    @Override
    public boolean add(E element) {
        if (size() == itemArray.length -1){
            widen();
        }
        int size = size();
        itemArray[size] = element;
        itemCreationDates[size] = LocalDateTime.now();
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (index == itemArray.length -1){
            widen();
        }
        if (isEmpty() && index == 0){
            return add(element);
        }
        else if (index >= size()){
            throw new IndexOutOfBoundsException();
        }

        Object[] tempArray = new Object[itemArray.length +1];
        LocalDateTime[] tempDates = new LocalDateTime[itemArray.length+1];
        for (int i = 0; i < index; i ++){
            tempArray[i] = itemArray[i];
            tempDates[i] = itemCreationDates[i];
        }
        tempArray[index] = element;
        tempDates[index] = LocalDateTime.now();
        for(int i = index; i < itemArray.length; i++){
            tempArray[i +1] = itemArray[i];
            tempDates[i +1] = itemCreationDates[i];
        }
        itemArray = tempArray;
        itemCreationDates = tempDates;
        return true;
    }

    @Override
    public boolean remove(E element) {
        Object[] tempArray = new Object[itemArray.length -1];
        LocalDateTime[] tempDates = new LocalDateTime[itemArray.length-1];
        int index = 0;
        int size = size();
        for (int i = 0; i < size; i++){
            if (itemArray[i].equals(element)){
                index = i;
                break;
            }
            tempArray[i] = itemArray[i];
            tempDates[i] = itemCreationDates[i];
        }
        for (int i = index; i < size-1; i++){
            tempArray[i] = itemArray[++index];
            tempDates[i] = itemCreationDates[index];
        }
        itemArray = tempArray;
        itemCreationDates = tempDates;
        return true;
    }

    public boolean remove(int index){
        if (index < 0 || index > itemArray.length -1)
            throw new IndexOutOfBoundsException();
        remove((E)itemArray[index]);
        return true;
    }

    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_CAPACITY];
        itemCreationDates = new LocalDateTime[DEFAULT_CAPACITY];
    }

    private void clean(){
        int size = size();
        while (size > 0){
            if (itemCreationDates[size-1].toLocalTime().isBefore(deletionDate.toLocalTime())){
                remove((E)itemArray[size-1]);
                --size;
            }
        }
    }

    @Override
    public void setDeletionDate(LocalDateTime date) {
        deletionDate = date;
        clean();
    }
}
