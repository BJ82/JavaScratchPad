package org.LinkList;

public class LinkList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /*Insert at the end of list*/
    public void insert(int data){

        Node newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }
        Node last = getLastNode();
        last.setNext(newNode);

    }

    /*Insert at specified index*/
    public void insert(int data,int index){
        Node newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }
        Node prev = getNode(index-1);
        Node current = getNode(index);
        newNode.setNext(current);
        prev.setNext(newNode);
    }

    /*Reverse the list*/
    public void reverse(){
        Node newHead = null;
        Node temp;
        while(getHead()!=null){
            temp = getHead();
            setHead(getHead().getNext());
            temp.setNext(newHead);
            newHead = temp;

        }
        setHead(newHead);
    }

    /*Print list to console*/
    public void print(){

        if(getHead() == null){
            System.out.println("List is Empty");
            return;
        }
        Node temp = getHead();
        System.out.println("List:");
        while(temp!= null){
            System.out.println(temp.getData()+" ");
            temp = temp.getNext();
        }
    }

    /*Remove from specific index*/
    public void remove(int index){
        Node prev = getNode(index-1);
        Node current = getNode(index);
        prev.setNext(current.getNext());
        current.setNext(null);
    }

    /*Remove last entry in the list*/
    public void remove(){
        Node secondLast = getNode(size()-1);
        secondLast.setNext(null);
    }

    /*Get the size of list*/
    public int size(){

        if(getHead() == null)
            return -1;

        int size = 0;
        Node temp = getHead();
        while(temp!= null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }
    private Node createNode(int data){
        return new Node(data);
    }

    private Node getLastNode(){

        if(getHead() == null)
            return null;

        Node temp = getHead();

        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp;
    }
    private Node getNode(int index){
        Node temp = getHead();

        for(int i=1;i<index;i++){
            temp = temp.getNext();
        }
        return temp;
    }

}
