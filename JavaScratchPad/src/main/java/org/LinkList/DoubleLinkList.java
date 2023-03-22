package org.LinkList;

/*Double Linked List*/
public class DoubleLinkList extends LinkList{

    private Node head;

    public Node getHead() {
        return head;
    }

    private void setHead(Node head) {
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
        newNode.setPrev(last);
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
