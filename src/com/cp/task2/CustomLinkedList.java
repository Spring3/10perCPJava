package com.cp.task2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by user on 16.03.2015.
 */
public class CustomLinkedList<E> implements CustomList<E>{

    public CustomLinkedList(LocalDateTime date){
        this.date = date;
    }

    private LocalDateTime date;
    private Node<E> firstNode;

    public void setDeletionDate(LocalDateTime date){
        this.date = date;
        clean();
    }

    private void clean() {
        List<Node<E>> nodesToDelete = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            Node<E> currentNode = getNode(i);
            if (currentNode != null) {
                if (currentNode.getCreationDate().toLocalTime().isBefore(date.toLocalTime())) {
                    nodesToDelete.add(currentNode);
                }
            }
        }
        for (Node<E> node : nodesToDelete) {
            remove(node);
            System.out.println("Node: " + node + " was removed");
        }
    }

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
        if (firstNode != tempNode)
            firstNode = tempNode;
        firstNode = null;
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
            Node<E> addedNode = new Node<>(wasLastNode, firstNode, element);
            firstNode.setPrevious(addedNode);
            wasLastNode.setNext(addedNode);
        }
        return true;
    }

    public boolean add(int index, E element){
        if (index < 0 || index >= size()){
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

    public boolean isEmpty(){
        return size() == 0;
    }

    private void findAndAdd(int index, E element){
        Node<E> currentNode = firstNode;
        for (int i = 1; i != index; i++) {
            currentNode = currentNode.getNext();
        }
        Node<E> newNode = new Node(currentNode, currentNode.getNext(), element);
        currentNode.getNext().setPrevious(newNode);
        currentNode.setNext(newNode);
    }

    public int size(){
        int index = 0;
        if (firstNode != null) {
            index ++;
            Node<E> startNode = firstNode.getNext();
            while (startNode != firstNode) {
                startNode = startNode.getNext();
                index++;
            }

        }
        return index;
    }

    public E get(int index) {
        return getNode(index).getValue();
    }

    private Node<E> getNode(int index){
        if (firstNode == null){
            return null;
        }
        else if (index > size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<E> result = firstNode;
        for (int i = 0 ; i != index; i ++){
            result = result.getNext();
        }
        return result;
    }

    private boolean remove(Node<E> nodeToRemove){
        if (firstNode == null){
            return false;
        }
        if (firstNode == nodeToRemove){
            removeFirst();
            return true;
        }
        Node<E> currentNode = firstNode.getNext();
        while (currentNode != firstNode){
            if (currentNode == nodeToRemove){
                currentNode.getPrevious().setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(currentNode.getPrevious());
                currentNode.setNext(null);
                currentNode.setPrevious(null);
                return true;
            }
        }
        return false;
    }

    public boolean remove(E element){
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
