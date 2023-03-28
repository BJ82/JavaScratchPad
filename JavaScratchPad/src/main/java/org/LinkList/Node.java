package org.LinkList;

public class Node<T>{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Node<T> next;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    private Node<T> prev;

    public Node <T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }


    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }




}
