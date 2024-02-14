package org.Queue;

import org.LinkList.DoubleLinkList;
import org.LinkList.Node;

public class QueueImpl<T> implements org.Interfaces.Queue <T>{

    private final DoubleLinkList<T> list;

    private Node <T> front;

    public T getFront() {

        return front.getData();
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


    public QueueImpl() {
        list = new DoubleLinkList<>();
        front = rear = null;
    }

    /*Add entry to Queue*/
    @Override
    public void enque(T entry) {
        list.insertFirst(entry);
        if(list.size() == 1)
            setFront(list.getHead());

        setRear(list.getHead());
    }

    /*Remove Entry From Queue*/
    @Override
    public T deque() {

        T frontVal = getFront();
        list.removeLast();
        setFront(list.getNode(list.size()));
        return frontVal;
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

    public void printQueue(){
        list.revrsTrvsl(list.getHead());
    }
}
