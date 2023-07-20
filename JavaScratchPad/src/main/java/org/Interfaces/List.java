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

    public default void fwrdTrvsl(Node<T> n) {

        if(null == n)
            return;

        System.out.println(n.getData());
        fwrdTrvsl(n.getNext());
    }

    public default void revrsTrvsl(Node<T> n) {

        if(n == null){

            return;
        }

        revrsTrvsl(n.getNext());
        System.out.println(n.getData());
    }

     public default Node<T> getLastNode(){

         if(getHead() == null)
             return null;

         Node<T> temp = getHead();

         while(temp.getNext() != null){
             temp = temp.getNext();
         }
         return temp;

    }

    public default Node<T> getNode(int index){
        Node<T> temp = getHead();

        for(int i=1;i<index;i++){
            temp = temp.getNext();
        }
        return temp;
    }

}
