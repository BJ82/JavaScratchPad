package org.Stack;

import org.LinkList.LinkList;
import org.LinkList.Node;

/*Stack Implementation using Linked List*/
public class Stack <T>{


    private T top;//change type to T

    public T getTop() {
        return top;
    }//change return type to T

    private void setTop(T top) {//change parameter to T
        this.top = top;
    }



    private final LinkList<T> list;

    private LinkList<T> getList() {
        return list;
    }



    public Stack() {
        list = new LinkList<>();
    }



    public void push(T entry){

      getList().insertFirst(entry);
        setTop(getList().get(0));//change to setTop(getList().get(0))
    }


    public T pop(){

        if(getTop()==null)
            return null;

        T data = getList().get(0);//change to getList().get(0)
        getList().removeFirst();
        setTop(getList().get(0));//change to setTop(getList().get(0))
        return data;
    }


    public boolean isEmpty(){
        return getTop() == null;
    }


    public T getTopEntry(){

        if(getList().get(0)==null)//change to getList().get(0)
            return null;
        return getList().get(0); //change to getList().get(0)
    }


    public void print(){
        if(getList().get(0) == null){
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Stack:");
        getList().printFwd();


    }
}
