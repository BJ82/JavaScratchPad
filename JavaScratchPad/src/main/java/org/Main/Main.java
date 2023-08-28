package org.Main;

import org.Interfaces.List;
import org.Interfaces.Queue;
import org.LinkList.DoubleLinkList;
import org.Stack.Stack;
import org.Utils.Utils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Is sts Palindrome:"+ Utils.isPalindrome("sts"));
        System.out.println("Is 15151 Palindrome:" + Utils.isPalindrome(15151));
        List<Integer> list = new DoubleLinkList<>();
        Utils.printToConsole(list);

        for(int i=6;i>=1;i--){
            list.insertLast(i);
        }

        Utils.printToConsole(list);
        list.reverse();
        System.out.println("After Reversing");
        Utils.printToConsole(list);
        System.out.println("Inserting Entry at index 2");
        list.insert(1000,2);
        Utils.printToConsole(list);
        list.remove(2);
        System.out.println("After removing Entry at index 2");
        Utils.printToConsole(list);
        System.out.println("Size of List:"+list.size());
        list.removeLast();
        System.out.println("After removing last entry");
        Utils.printToConsole(list);
        System.out.println("Size of List:"+list.size());

        System.out.println("Forward Traversal Of Link List:");
        list.fwrdTrvsl(list.getHead());

        System.out.println("Reverse Traversal Of Link List:");
        list.revrsTrvsl(list.getHead());


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
        System.out.println("Is Balanced:"+Utils.isBalancedParenthesis("{[()()]}"));


        Queue<Integer> q = new org.Queue.Queue<>();
        for (int i=1;i<=7;i++){
            q.Enque(i);
        }


        System.out.println("Queue size: "+q.size());
        System.out.println("Queue Entries:");
        while(!q.isEmpty()){
            System.out.println(q.Deque());
        }


        int [] arry1 = {4,2,5,10,3,7};

        Utils.InsertionSort(arry1);

        System.out.println("Insertion Sort");
        Utils.printToConsole(Arrays.stream( arry1 ).boxed().toArray( Integer[]::new ));

        int [] arry2 = {100,76,5,10,3,7};

        Utils.BubbleSort(arry2);

        System.out.println("Bubble Sort");
        Utils.printToConsole(Arrays.stream( arry2 ).boxed().toArray( Integer[]::new ));



        int [] arry3 = {102,76,251,10,3,7};

        Utils.SelectionSort(arry3);

        System.out.println("Selection Sort");
        Utils.printToConsole(Arrays.stream( arry3 ).boxed().toArray( Integer[]::new ));


        Integer [] arry4 = {122,121,65,34,28,16,14,10,1};

        Utils.MergeSort(arry4);

        System.out.println("Merge Sort");
        Utils.printToConsole(arry4);

    }

}