package org.Stack;

import org.LinkList.LinkList;
import org.LinkList.Node;

/*Stack Implementation using Linked List*/
public class Stack <T>{


    private Node<T> TOP;

    public Node<T> getTOP() {
        return TOP;
    }

    private void setTOP(Node<T> TOP) {
        this.TOP = TOP;
    }



    private final LinkList<T> list;

    private LinkList<T> getlist() {
        return list;
    }



    public Stack() {
        list = new LinkList<>();
    }



    public void push(T entry){

      getlist().insertFirst(entry);
      setTOP(getlist().getHead());
    }


    public T pop(){

        if(getTOP()==null)
            return null;

        T data = getlist().getHead().getData();
        getlist().removeFirst();
        setTOP(getlist().getHead());
        return data;
    }


    public boolean isEmpty(){
        return getTOP() == null;
    }


    public T getTopEntry(){

        if(getlist().getHead()==null)
            return null;
        return getlist().getHead().getData();
    }


    public void print(){
        if(getlist().getHead() == null){
            System.out.println("Stack is Empty");
            return;
        }
        Node<T> temp = getlist().getHead();
        System.out.println("Stack:");
        while(temp!= null){
            System.out.println(temp.getData()+" ");
            temp = temp.getNext();
        }
    }
}
