package org.Queue;

import org.LinkList.DoubleLinkList;
import org.LinkList.Node;

public class QueueImpl<T> implements org.Interfaces.Queue <T>{

    private final DoubleLinkList<T> list;

    private T front;//Change type to T

    public T getFront() {

        return front;
    }

    private void setFront(T front) { //Change parameter to T
        this.front = front;
    }


    private T rear;//Change type to T

    //Change return type to T
    public T getRear() {
        return rear;
    }

    private void setRear(T rear) {//Change parameter to T
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
            setFront(list.get(0)); //Change to list.get(0)

        setRear(list.get(0)); //Change to list.get(0)
    }

    /*Remove Entry From Queue*/
    @Override
    public T deque() {

        T frontVal = getFront();
        list.removeLast();
        setFront(list.get(list.size()-1));  //Change to setFront(list.get(list.size()-1)
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
        list.printRvr(); //Change to list.printRvr()
    }
}
