package org.Stack;

import org.LinkList.LinkList;
import org.LinkList.Node;

/*Stack Implementation using Linked List*/
public class Stack <T>{


    private Node<T> top;

    public Node<T> getTop() {
        return top;
    }

    private void setTop(Node<T> top) {
        this.top = top;
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
      setTop(getlist().getHead());
    }


    public T pop(){

        if(getTop()==null)
            return null;

        T data = getlist().getHead().getData();
        getlist().removeFirst();
        setTop(getlist().getHead());
        return data;
    }


    public boolean isEmpty(){
        return getTop() == null;
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
