package com.cp.task2;

import java.util.NoSuchElementException;

/**
 * Created by user on 16.03.2015.
 */
public class CustomLinkedList<E>{

    public CustomLinkedList(){
    }

    private Node<E> firstNode;

    public E getFirst(){
        if (firstNode == null){
            throw new NoSuchElementException();
        }
        else
        {
            return firstNode.getValue();
        }
    }

    public E getLast(){
        if (firstNode == null){
            throw new NoSuchElementException();
        }
        else{
            return firstNode.getPrevious().getValue();
        }
    }

    public void removeFirst(){

    }

    public void removeLast(){

    }

    public void addFirst(E element){

    }

    public void addLast(E element){

    }

    public boolean contains(E element){
        if (firstNode == null || element == null ){
            return false;
        }
        if (firstNode.getValue().equals(element))
            return true;

        Node<E> startNode = firstNode.getNext();
        while(startNode != firstNode){
            if (startNode.getValue().equals(element)){
                return true;
            }
            startNode = startNode.getNext();
        }
        return false;
    }

    public boolean add(E element){
        if (firstNode == null){
            firstNode = new Node<E>();
            firstNode.setPrevious(firstNode);
            firstNode.setNext(firstNode);
            firstNode.setValue(element);
        }
        else{
            Node<E> wasLastNode = firstNode.getPrevious();
            Node<E> addedNode = new Node<>(firstNode.getPrevious(), firstNode, element);
            firstNode.setPrevious(addedNode);
            wasLastNode.setNext(addedNode);
        }
        return true;
    }

    public int size(){
        int index = 0;
        if (firstNode != null) {
            index ++;
            Node<E> startNode = firstNode;
            while (!startNode.getNext().equals(firstNode)) {
                index++;
                startNode = startNode.getNext();
            }

        }
        return index;
    }

    public E get(int index){
        return null;
    }

    public boolean remove(E element){
        return false;
    }

    public void clear(){

    }

    public boolean hasNext(){
        return false;
    }

    public E next(){
        return null;
    }

    public E prevous(){
        return null;
    }


}
