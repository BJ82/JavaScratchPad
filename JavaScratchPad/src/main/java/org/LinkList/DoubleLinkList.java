package org.LinkList;

import org.Interfaces.List;

/*Double Linked List*/
public class DoubleLinkList<T> implements List<T> {



    private Node<T> head;

    public Node <T> getHead() {
        return head;
    }

    private void setHead(Node<T> head) {
        this.head = head;
    }



    /*Insert at beginning of list*/
    public void insertFirst(T data){

        Node<T> newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }

        newNode.setNext(getHead());
        getHead().setPrev(newNode);
        setHead(newNode);

    }



    /*Insert at the end of list*/
    public void insertLast(T data){

        Node<T> newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }
        Node<T> last = getLastNode();
        last.setNext(newNode);
        newNode.setPrev(last);
    }



    /*Insert at specified index*/
    public void insert(T data,int index){
        Node<T> newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }
        Node<T> prev = getNode(index-1);
        Node<T> current = getNode(index);
        current.setPrev(newNode);
        newNode.setNext(current);
        newNode.setPrev(prev);
        prev.setNext(newNode);
    }



    /*Remove from specific index*/
    public void remove(int index){
        Node<T> prev = getNode(index-1);
        Node<T> current = getNode(index);
        prev.setNext(current.getNext());
        current.getNext().setPrev(prev);
        current.setNext(null);
    }



    /*Remove last entry in the list*/
    public void removeLast(){

        Node<T> secondLast = getNode(size()-1);
        secondLast.setNext(null);

        removeNode(getNode(size()));
    }



    /*Remove first entry in the list*/
    public void removeFirst(){
        Node<T> temp = getHead();
        if(temp!=null){
            setHead(temp.getNext());
            removeNode(temp);
        }



    }



    private void removeNode(Node<T> toRemove){
        toRemove.setNext(null);
        toRemove.setPrev(null);
        toRemove=null;
    }



    public void reverse(){
        Node<T> newHead = null;
        Node<T> temp;
        while(getHead()!=null){
            temp = getHead();
            setHead(getHead().getNext());
            temp.setNext(newHead);
            if(newHead!=null)
                newHead.setPrev(temp);
            newHead = temp;

        }
        setHead(newHead);
    }

    public int size(){

        if(getHead() == null)
            return -1;

        int size = 0;
        Node<T> temp = getHead();
        while(temp!= null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == -1;
    }

    private Node<T> createNode(T data){
        return new Node<>(data);
    }

    private Node<T> getLastNode(){

        if(getHead() == null)
            return null;

        Node<T> temp = getHead();

        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp;
    }
    private Node<T> getNode(int index){
        Node<T> temp = getHead();

        for(int i=1;i<index;i++){
            temp = temp.getNext();
        }
        return temp;
    }
}
