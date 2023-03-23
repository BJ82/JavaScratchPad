package org.LinkList;

public class Node<T>{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private Node prev;

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }


    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }




}
