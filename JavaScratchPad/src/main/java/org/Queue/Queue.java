package org.Queue;

import org.LinkList.DoubleLinkList;
import org.LinkList.Node;

public class Queue<T> implements org.Interfaces.Queue <T>{

    private final DoubleLinkList<T> list;

    private Node <T> front;

    public Node <T> getFront() {
        return front;
    }

    private void setFront(Node <T> front) {
        this.front = front;
    }


    private Node <T> rear;

    public Node <T> getRear() {
        return rear;
    }

    private void setRear(Node <T> rear) {
        this.rear = rear;
    }


    public Queue() {
        list = new DoubleLinkList<>();
        front = rear = null;
    }

    /*Add entry to Queue*/
    @Override
    public void Enque(T entry) {
        list.insertFirst(entry);
        if(list.size() == 1)
            setFront(list.getHead());

        setRear(list.getHead());
    }

    /*Remove Entry From Queue*/
    @Override
    public T Deque() {

        T val =  getFront().getData();
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
            val = getFront().getData();
        else
            val =  null;

        return val;
    }

    @Override
    public boolean isEmpty() {

        return size() == -1;
    }

    /*Get Size Of Queue*/
    @Override
    public int size() {
        return list.size();
    }
}
