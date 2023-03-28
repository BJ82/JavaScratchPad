package org.Interfaces;

import org.LinkList.Node;

public interface List <T>{

    void insertLast(T data);

    void insert(T data,int index);

    void insertFirst(T data);

    void remove(int index);

    void removeLast();

    void removeFirst();

    int size();

    boolean isEmpty();

    Node<T> getHead();
}
