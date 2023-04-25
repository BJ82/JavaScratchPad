package org.Utils;

import org.LinkList.Node;

import org.Interfaces.List;
import org.Stack.Stack;

import java.util.ArrayList;

public class Utils {

    public static <T> void print(List<T> list){

        if(list.getHead() == null){
            System.out.println("List is Empty");
            return;
        }
        Node<T> temp = list.getHead();
        System.out.println("List:");
        while(temp!= null){
            System.out.println(temp.getData()+" ");
            temp = temp.getNext();
        }
    }

    public static boolean isPalindrome(int num){
        String strNum = intToString(num);
        return checkIfPalindrome(strNum);

    }
    public static boolean isPalindrome(String str){
        return checkIfPalindrome(str);
    }
    private static boolean checkIfPalindrome(String s){
        boolean isPalindrome = false;  //O(1)   1
        int last=s.length()-1;         //O(1)   1
        for(int i=0;i<s.length();i++){ //O(1) 1  //O(1) n+1  //O(1) n+1
            if(s.charAt(i) == s.charAt(last)){ //O(1) n  //O(1) n  //O(1) n
                if(i<=last) //O(1) n/2
                    isPalindrome = true; //O(1) 1
                last--;  //O(1) n/2
            }
            else{
                isPalindrome = false;   //O(1)  1
                break;                  //O(1)  1
            }
        }
        return isPalindrome;        //O(1)  1
    }
    private static String intToString(int i){
        return Integer.valueOf(i).toString();
    }

    public static boolean isBalancedParenthesis(String s){

        Stack<Character> stk = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(isOpening(s.charAt(i)))
            {
                stk.push(s.charAt(i));
            }

            if(isClosing(s.charAt(i)))
            {
                char c = 0;
                if(!stk.isEmpty())
                    c = stk.pop();

                if(isNoMatch(c,s.charAt(i)))
                    return false;
            }
        }

        return stk.isEmpty();
    }

    private static boolean isOpening(char c){

        String opening = "{([";

        return opening.contains(Character.toString(c));
    }

    private static boolean isClosing(char c){
        String closing = "})]";

        return closing.contains(Character.toString(c));
    }

    private static boolean isNoMatch(char c1,char c2){
        String opening = "{([";
        String closing = "})]";

        return opening.indexOf(Character.toString(c1)) != closing.indexOf(Character.toString(c2));
    }

    public static ArrayList<Integer> BubbleSort(ArrayList <Integer> list){

        int n = list.size();
        boolean flag = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<=(n-i-2);j++){
                if(list.get(j).compareTo(list.get(j+1)) > 0){
                    list = swap(list,j,j+1);
                    flag = true;
                }
            }
            if(flag == false)
                break;
        }
        return list;
    }

    private static <T> ArrayList swap(ArrayList<T> list,int i,int j){
        Object temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, (T) temp);

        return list;
    }

}
