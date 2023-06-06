package org.Utils;

import org.LinkList.Node;

import org.Interfaces.List;
import org.Stack.Stack;

import java.util.ArrayList;
import java.util.Collections;

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

        String c1Str = Character.toString(c1);
        String c2Str = Character.toString(c2);

        return opening.indexOf(c1Str) != closing.indexOf(c2Str);
    }

    public static int[] BubbleSort(int[] list){

        int n = list.length;
        boolean flag = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<=(n-i-2);j++){
                if(list[j] > list[j+1]){
                    list = swap(list,j,j+1);
                    flag = true;
                }
            }
            if(flag == false)
                break;
        }
        return list;
    }

    private static  int[] swap(int[] list,int i,int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;

        return list;
    }

    public static int[] InsertionSort(int[] list){

        int value;
        int hole;
        for(int i=1;i<list.length;i++){
            value = list[i];
            hole = i;
            while(hole>0 && list[hole-1]>value)
            {
                list[hole] = list[hole-1];
                hole--;
            }
            list[hole] = value;
        }
        return list;
    }

    public static int[] SelectionSort(int[] list){
        int n = list.length;
        int imin;
        for(int i=0;i<n-2;i++){
            imin = i;
            for(int j=i+1;j<n;j++){
                if(list[j] < list[imin])
                    imin = j;
            }
            swap(list,i,imin);
        }
        return list;
    }

    public static <T> void printArray(T [] arry){
        for(T i:arry){
            System.out.println(i);
        }
    }

    public static int[] MergeSort(int [] arry){

        int size = arry.length;
        if(size < 2)
            return arry;

        int mid = size/2;
        int [] left = new int [mid];
        int [] right = new int [size - mid];

        for(int i=0;i<mid;i++){
            left[i] = arry[i];
        }

        for(int j=mid;j<size;j++){
            right[j-mid] = arry[j];
        }

        left = MergeSort(left);
        right = MergeSort(right);
        arry = Merge(left,right,arry);
        return arry;

    }

    public static int[] Merge(int [] left,int [] right,int [] Arry){

        int leftArrySize = left.length;
        int rightArrySize = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftArrySize && j < rightArrySize){

            if(left[i] < right[j]){

                Arry[k] = left[i];
                i++;
            }

            else if(right[j] < left[i]){

                Arry[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < leftArrySize){
            Arry[k] = left[i];
            i++;
            k++;
        }
        while(j < rightArrySize){
            Arry[k] = right[j];
            j++;
            k++;
        }

        return Arry;

    }

}
