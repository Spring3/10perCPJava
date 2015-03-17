package com.cp.task2;

import java.time.LocalDateTime;

/**
 * Created by user on 16.03.2015.
 */
public class Node<T> {
    public Node(){
        setCreationDate(LocalDateTime.now());
    }

    public Node(Node<T> previous, Node<T> next, T value){
        setPrevious(previous);
        setNext(next);
        setValue(value);
        setCreationDate(LocalDateTime.now());
    }

    private Node<T> nextNode;
    private Node<T> prevNode;
    private T value;
    private LocalDateTime creationDate;

    public Node<T> getNext(){
        return nextNode;
    }

    public void setNext(Node<T> node){
        nextNode = node;
    }

    public Node<T> getPrevious(){
        return prevNode;
    }

    public void setPrevious(Node<T> node){
        prevNode = node;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T newValue){
        value = newValue;
    }

    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    private void setCreationDate(LocalDateTime date){
        creationDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (nextNode != null ? !nextNode.equals(node.nextNode) : node.nextNode != null) return false;
        if (prevNode != null ? !prevNode.equals(node.prevNode) : node.prevNode != null) return false;
        if (value != null ? !value.equals(node.value) : node.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nextNode != null ? nextNode.hashCode() : 0;
        result = 31 * result + (prevNode != null ? prevNode.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Node: value= " + value;
    }
}
