package com.cp.task2;

import java.time.LocalDateTime;

/**
 * Created by user on 17.03.2015.
 */
public interface CustomList<E> {
    public int size();
    public boolean isEmpty();
    public boolean contains(E element);
    public E get(int index);
    public boolean add(E element);
    public boolean add(int index, E element);
    public boolean remove(E element);
    public void clear();
    public void setDeletionDate(LocalDateTime date);
}
