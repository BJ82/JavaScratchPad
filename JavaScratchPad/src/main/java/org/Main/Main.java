package org.Main;

import org.Interfaces.Queue;
import org.LinkList.DoubleLinkList;
import org.Stack.Stack;
import org.Utils.Utils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Is Palindrome:"+ Utils.isPalindrome("sts"));

        DoubleLinkList<Integer> list = new DoubleLinkList<>();
        list.print();

        for(int i=6;i>=1;i--){
            list.insertLast(i);
        }

        list.print();
        list.reverse();
        System.out.println("After Reversing");
        list.print();
        System.out.println("Inserting Entry at index 2");
        list.insert(1000,2);
        list.print();
        list.remove(2);
        System.out.println("After removing Entry at index 2");
        list.print();
        System.out.println("Size of List:"+list.size());
        list.removeLast();
        System.out.println("After removing last entry");
        list.print();
        System.out.println("Size of List:"+list.size());

        System.out.println("Stack");
        Stack<Integer> stk = new Stack<>();

        for(int i=1;i<=7;i++){
            stk.push(i);
        }

        System.out.println("Stack Entries:");
        stk.print();
        System.out.println("Stack TOP entry:"+stk.getTopEntry());
        stk.pop();
        stk.pop();
        stk.pop();
        System.out.println("Stack Entries After Calling POP:");
        stk.print();
        System.out.println("Is Balanced:"+Utils.isBalancedParenthesis("{[()()}]"));


        Queue<Integer> q = new org.Queue.Queue<>();
        for (int i=1;i<=7;i++){
            q.Enque(i);
        }


        System.out.println("Queue size: "+q.size());
        System.out.println("Queue Entries:");
        while(!q.isEmpty()){
            System.out.println(q.Deque());
        }

    }

}