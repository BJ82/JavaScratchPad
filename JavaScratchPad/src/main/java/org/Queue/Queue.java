package org.Queue;

import org.LinkList.DoubleLinkList;
import org.LinkList.Node;

public class Queue<T> implements org.Interfaces.Queue <T>{

    private DoubleLinkList list;

    public DoubleLinkList getList() {
        return list;
    }


    private Node front;

    public Node getFront() {
        return front;
    }

    private void setFront(Node front) {
        this.front = front;
    }


    private Node rear;

    public Node getRear() {
        return rear;
    }

    private void setRear(Node rear) {
        this.rear = rear;
    }


    public Queue() {
        list = new DoubleLinkList();
        front = rear = null;
    }

    /*Add entry to Queue*/
    @Override
    public void Enque(T entry) {
        list.insertFirst(entry,true);
        if(list.size() == 1)
            setFront(list.getHead());

        setRear(list.getHead());
    }

    /*Remove Entry From Queue*/
    @Override
    public T Deque() {

        T val = (T) getFront().getData();
        setFront(getFront().getPrev());
        if(getFront()!=null)
            getFront().setNext(null);
        else
            list.removeFirst();
        return val;

    }

    /*Get Entry From Queue Front */
    @Override
    public T Front() {
        T val;
        if(getFront()!=null)
            val =  (T) getFront().getData();
        val =  null;

        return val;
    }

    @Override
    public boolean isEmpty() {
        if(size()==-1)
            return true;
        return false;
    }

    /*Get Size Of Queue*/
    @Override
    public int size() {
        return list.size();
    }
}
