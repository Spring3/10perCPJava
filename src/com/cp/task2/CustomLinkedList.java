package com.cp.task2;

import com.sun.istack.internal.NotNull;

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
        return firstNode.getPrevious().getValue();
    }

    public boolean removeFirst(){
        if (firstNode == null){
            throw new NoSuchElementException();
        }
        Node<E> tempNode = firstNode.getNext();
        firstNode.getPrevious().setNext(tempNode);
        tempNode.setPrevious(firstNode.getPrevious());
        firstNode.setNext(null);
        firstNode.setPrevious(null);
        firstNode = tempNode;
        return true;
    }

    public boolean removeLast(){
        if (firstNode == null){
            throw new NoSuchElementException();
        }
        Node<E> newLast = firstNode.getPrevious().getPrevious();
        firstNode.getPrevious().setPrevious(null);
        firstNode.getPrevious().setNext(null);
        firstNode.setPrevious(newLast);
        newLast.setNext(firstNode);
        return true;
    }

    public void addFirst(E element){
        if (firstNode == null){
            firstNode = new Node<E>();
            firstNode.setNext(firstNode);
            firstNode.setPrevious(firstNode);
            firstNode.setValue(element);
        }
        Node<E> newNode = new Node(firstNode.getPrevious(), firstNode, element);
        firstNode.getPrevious().setNext(newNode);
        firstNode.setPrevious(newNode);
        firstNode = newNode;
    }

    public void addLast(E element){
        add(element);
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

    public boolean add(int index, E element){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
            return true;
        }
        else if(index == size()){
            addLast(element);
            return true;
        }
        if (firstNode == null) {
            addFirst(null);
            findAndAdd(index, element);
            return true;
        }
        else{
           findAndAdd(index, element);
            return true;
        }
    }

    private void findAndAdd(int index, E element){
        Node<E> currentNode = firstNode;
        for (int i = 0; i != index; i++) {
            if (currentNode.getNext() == firstNode || currentNode.getNext() == null) {
                addLast(null);
            }
            currentNode = currentNode.getNext();
        }
        Node<E> newNode = new Node(currentNode.getPrevious(), currentNode, element);
        currentNode.getPrevious().setNext(newNode);
        currentNode.setPrevious(newNode);
    }

    public int size(){
        int index = 0;
        if (firstNode != null) {
            index ++;
            Node<E> startNode = firstNode.getNext();
            while (startNode != firstNode) {
                index++;
                startNode = startNode.getNext();
            }

        }
        return index;
    }

    public E get(int index) {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            return getFirst();
        }
        else if (index == size()){
            return getLast();
        }

        Node<E> result = firstNode;
        for(int i = 0; i != index; i++) {
            if (result.getNext() == firstNode || result.getNext() == null){
                throw new IndexOutOfBoundsException();
            }
            result = result.getNext();
        }
        return result.getValue();
    }

    public boolean remove(@NotNull E element){
        if (firstNode == null){
            return false;
        }
        if (firstNode.getValue().equals(element)){
            removeFirst();
        }
        Node<E> currentNode = firstNode.getNext();
        while (currentNode != firstNode){
            if (currentNode.getValue().equals(element)){
                currentNode.getPrevious().setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(currentNode.getPrevious());
                currentNode.setNext(null);
                currentNode.setPrevious(null);
                return true;
            }
        }
        return false;
    }

    public void clear(){
        if (firstNode != null){
            while(firstNode.getNext() != firstNode){
                firstNode.getNext().setPrevious(null);
                firstNode.getNext().getNext().setPrevious(firstNode);
                Node<E> tempNode = firstNode.getNext().getNext();
                firstNode.getNext().setNext(null);
                firstNode.setNext(tempNode);
            }
            firstNode.setNext(null);
            firstNode.setPrevious(null);
            firstNode = null;
        }
    }
}
