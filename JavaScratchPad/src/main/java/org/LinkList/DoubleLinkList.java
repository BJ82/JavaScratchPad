package org.LinkList;

/*Double Linked List*/
public class DoubleLinkList<T> extends LinkList<T>{



    private Node head;

    public Node <T> getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }



    /*Insert at begining of list*/
    public void insertFirst(T data,boolean addToBegin){

        Node newNode = createNode(data);
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

        Node newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }
        Node last = getLastNode();
        last.setNext(newNode);
        newNode.setPrev(last);
    }



    /*Insert at specified index*/
    public void insert(T data,int index){
        Node newNode = createNode(data);
        if(getHead() == null){
            setHead(newNode);
            return;
        }
        Node prev = getNode(index-1);
        Node current = getNode(index);
        current.setPrev(newNode);
        newNode.setNext(current);
        newNode.setPrev(prev);
        prev.setNext(newNode);
    }



    /*Remove from specific index*/
    public void remove(int index){
        Node prev = getNode(index-1);
        Node current = getNode(index);
        prev.setNext(current.getNext());
        current.getNext().setPrev(prev);
        current.setNext(null);
    }



    /*Remove last entry in the list*/
    public void removeLast(){

        Node secondLast = getNode(size()-1);
        secondLast.setNext(null);

        removeNode(getNode(size()));
    }



    /*Remove first entry in the list*/
    public void removeFirst(){
        Node temp = getHead();
        if(temp!=null)
            setHead(temp.getNext());

        removeNode(temp);
    }



    private void removeNode(Node toRemove){
        toRemove.setNext(null);
        toRemove.setPrev(null);
        toRemove=null;
    }



    public void reverse(){
        Node newHead = null;
        Node temp;
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
}
