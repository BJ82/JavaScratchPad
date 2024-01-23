package org.Main;

import org.DesignPattern.Composite.Building;
import org.DesignPattern.Composite.Flat;
import org.DesignPattern.Composite.Residence;
import org.DesignPattern.Composite.Society;
import org.DesignPattern.Singleton;
import org.DesignPattern.Visitor.FlatOccupancyTracker;
import org.DesignPattern.Visitor.TotalFlatCalc;
import org.Interfaces.List;
import org.Interfaces.Queue;
import org.LinkList.DoubleLinkList;
import org.Stack.Stack;
import org.Utils.Utils;
import org.tree.BST;
import org.tree.TreeNode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
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

        String s = "say hello in this string multiple times to count no of hello";

        System.out.println("No of occurences: "+Utils.countOccurence(s,"hello"));


        Thread oddNoThread = new Thread(()->{
            for(int i=1;i<=49;i+=2){
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread evenNoThread = new Thread(()->{
            for(int i=2;i<=50;i+=2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /*oddNoThread.start();
        evenNoThread.start();
        evenNoThread.join();*/

       Thread t1 = new Thread(()->{
            Singleton.getObject();
            System.out.println("Singleton Object Count: "+Singleton.getCountOfObjects());
        });
        t1.start();


        Thread t2 = new Thread(()->{
            Singleton.getObject();
            System.out.println("Singleton Object Count: "+Singleton.getCountOfObjects());
        });
        t2.start();

        Thread t3 = new Thread(()->{
            Singleton.getObject();
            System.out.println("Singleton Object Count: "+Singleton.getCountOfObjects());
        });
        t3.start();

        Utils.printToConsole(Utils.currencyCount(868));

        Residence f1 = new Flat("FLAT-ONE",1);
        Residence f2 = new Flat("FLAT-TWO",2);
        Residence f3 = new Flat("FLAT-THREE", 3);
        Residence f4 = new Flat("FLAT-FOUR", 4);

        Residence b1 = new Building("First Building", java.util.List.of(f1,f2,f3,f4) , 2020);

        Residence f5 = new Flat("FLAT-ONE",1);
        Residence f6 = new Flat("FLAT-TWO",2);
        Residence f7 = new Flat("FLAT-THREE", 3);
        Residence f8 = new Flat("FLAT-FOUR", 4);

        Residence b2 = new Building("Second Building", java.util.List.of(f5,f6,f7,f8) , 2021);

        Residence b3 = new Building("First Building", java.util.List.of(f1,f2,f3,f4) , 2020);

        Residence society = new Society("Sushant Co-operative Housing Society", java.util.List.of(b1,b2),2019);
        Residence society2 = new Society("SushantLok Co-operative Housing Society", java.util.List.of(b3),2021);

        TotalFlatCalc totFlatCalc = new TotalFlatCalc();
        int count= (int)((Society) society).accept(totFlatCalc);
        System.out.println("Total No Of Flats in Society:"+count);

        System.out.println("Total Flats in building b2:"+ ((Building) b2).accept(totFlatCalc));

        FlatOccupancyTracker tracker = new FlatOccupancyTracker();
        tracker.track((Society) society, (Building) b1, (Flat) f1,"rented");
        tracker.track((Society) society, (Building) b1, (Flat) f2,"rented");
        tracker.track((Society) society, (Building) b1, (Flat) f3,"owner occupied");
        tracker.track((Society) society, (Building) b1, (Flat) f4,"rented");

        tracker.track((Society) society, (Building) b2, (Flat) f5,"owner occupied");
        tracker.track((Society) society, (Building) b2, (Flat) f6,"owner occupied");
        tracker.track((Society) society, (Building) b2, (Flat) f7,"owner occupied");
        tracker.track((Society) society, (Building) b2, (Flat) f8,"rented");

        tracker.track((Society) society2, (Building) b3, (Flat) f1,"rented");
        tracker.track((Society) society2, (Building) b3, (Flat) f2,"rented");
        tracker.track((Society) society2, (Building) b3, (Flat) f3,"rented");
        tracker.track((Society) society2, (Building) b3, (Flat) f4,"rented");

        String status = (String) ((Society) society).accept(tracker);
        String status1 = (String) ((Building) b2).accept(tracker);
        String status2 = (String) ((Building) b3).accept(tracker);
        String status3 = (String) ((Society) society2).accept(tracker);
        System.out.println(status);
        System.out.println(status1);
        System.out.println(status2);
        System.out.println(status3);

        String t = "3 1 5 N 2 4 8 N N N N 7 N 6";
        TreeNode root = BST.buildTree(t);
        BST bstree = new BST();
        System.out.println(bstree.isValidBST(root));
    }


}