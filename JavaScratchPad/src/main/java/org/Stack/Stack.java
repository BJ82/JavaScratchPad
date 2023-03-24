package org.Stack;

import org.LinkList.LinkList;
import org.LinkList.Node;

/*Stack Implementation using Linked List*/
public class Stack <T>{


    private Node TOP;

    public Node getTOP() {
        return TOP;
    }

    private void setTOP(Node TOP) {
        this.TOP = TOP;
    }



    private LinkList llist;

    private LinkList getlist() {
        return llist;
    }



    public Stack() {
        llist = new LinkList<T>();
    }



    public void push(T entry){

      getlist().insertFirst(entry);
      setTOP(getlist().getHead());
    };


    public T pop(){

        if(getTOP()==null)
            return null;

        T data = (T) getlist().getHead().getData();
        getlist().removeFirst();
        setTOP(getlist().getHead());
        return data;
    }


    public boolean isEmpty(){
        if(getTOP()==null)
            return true;
        else
            return false;
    };


    public T getTopEntry(){

        if(getlist().getHead()==null)
            return null;
        return (T) getlist().getHead().getData();
    };


    public void print(){
        if(getlist().getHead() == null){
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = getlist().getHead();
        System.out.println("Stack:");
        while(temp!= null){
            System.out.println(temp.getData()+" ");
            temp = temp.getNext();
        }
    }
}
