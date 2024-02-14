package org.Interfaces;

import org.LinkList.Node;

public interface List <T>{

    void insertLast(T data);

    void insert(T data,int index);

    void insertFirst(T data);

    void remove(int index);

    void removeLast();

    void removeFirst();

    void reverse();

    int size();

    boolean isEmpty();

    Node<T> getHead();

    public default T get(int index){
        Node<T> temp = getHead();
        T val = null;
        for(int i=0;i<=index;i++){

            if(temp == null){
                return (T) Integer.valueOf(-1);
            }
            val = temp.getData();
            temp = temp.getNext();
        }
        return val;
    }

    public default T getFirst(){
        return get(0);
    }

    public default T getLast(){
        return get(size()-1);
    }

    public void printFwd();

    public void printRvr();

}
