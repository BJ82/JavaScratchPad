package org.LinkList;

import org.Interfaces.List;
import org.utils.Utils;

/*Single Linked List*/
public class LinkList <T> implements List<T> {

    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    private void setHead(Node<T> head) {
        this.head = head;
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

    }

    /*Insert at specified index*/
    public void insert(T data,int index){
        Node<T> newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }

        Node<T> currentNode = getNode(index);
        newNode.setNext(currentNode);

        Node<T> prevNode = getNode(index-1);
        prevNode.setNext(newNode);
    }

    /*Insert at beginning*/
    public void insertFirst(T data){
        Node<T> newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }

        newNode.setNext(getHead());
        setHead(newNode);
    }

    /*Reverse the list*/
    public void reverse() {

        Node<T> nextNode;
        Node<T> newHead=null;
        Node<T> currentNode = getHead();

        while(currentNode !=null){
            nextNode = currentNode.getNext();
            currentNode.setNext(newHead);
            newHead = currentNode;
            currentNode = nextNode;
        }
        setHead(newHead);
    }

    private Node<T> next(Node<T> n){
        return n.getNext();
    }

    /*Remove from specific index*/
    public void remove(int index){
        Node<T> prev = getNode(index-1);
        Node<T> current = getNode(index);
        prev.setNext(current.getNext());
        current.setNext(null);
    }

    /*Remove last entry in the list*/
    public void removeLast(){
        Node<T> secondLast = getNode(size()-1);
        secondLast.setNext(null);
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
    }

    
    /*Get the size of list*/
    public int size(){

        return getSize(getHead());
    }

    private int getSize(Node<T> from){

        if(Utils.isNull(from))
            return 0;

        int size=1;
        size = size + getSize(from.getNext());

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == -1;
    }

    public void printFwd(){
        fwrdTrvsl(getHead());
    }

    public void printRvr(){
        revrsTrvsl(getHead());
    }

    private Node<T> createNode(T data){
        return new Node<>(data);
    }

    private void fwrdTrvsl(Node<T> n) {

        if(null == n)
            return;

        System.out.println(n.getData());
        fwrdTrvsl(n.getNext());
    }

    private void revrsTrvsl(Node<T> n) {

        if(n == null){

            return;
        }

        revrsTrvsl(n.getNext());
        System.out.println(n.getData());
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
