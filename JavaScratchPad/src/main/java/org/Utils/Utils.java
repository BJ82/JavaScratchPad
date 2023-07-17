package org.Utils;

import org.LinkList.Node;

import org.Interfaces.List;
import org.Stack.Stack;

public class Utils {

    public static <T> void printToConsole(List<T> list){

        if(null == list)
            return;

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

    public static <T> void printToConsole(T [] arry){

        if(null == arry)
            return;

        for(T i:arry){
            System.out.println(i);
        }
    }

    public static boolean isPalindrome(int num){

        if(intToString(num).isEmpty())
            return false;

        String numAsStr = intToString(num);
        return checkIfPalindrome(numAsStr,0,getLastIndex(numAsStr));

    }
    public static boolean isPalindrome(String str){

        if(isNull(str) || str.isEmpty())
            return false;

        return checkIfPalindrome(str,0,getLastIndex(str));
    }
    /*private static boolean checkIfPalindrome(String s){
        boolean isPalindrome = true;
        int indx = 0;
        int lastIndx=getLastIndex(s);
        while(indx<=lastIndx){
            if(!isEqual(s,indx,lastIndx)){
                isPalindrome = false;
                break;
            }
            indx++;
            lastIndx--;
        }
        return isPalindrome;
    }*/

    private static boolean checkIfPalindrome(String s,int indx,int lstIndx){
        if(indx>lstIndx)
            return true;

        if(!isEqual(s,indx,lstIndx))
            return false;

        return checkIfPalindrome(s,++indx,--lstIndx);
    }

    private static boolean isEqual(String s,int indx1,int indx2){
        return s.charAt(indx1) == s.charAt(indx2);
    }

    private static boolean isNull(Object o){
        return null == o;
    }

    private static int getLastIndex(String s){
        return s.length()-1;
    }

    private static String intToString(int i){
        return Integer.valueOf(i).toString();
    }

    public static boolean isBalancedParenthesis(String s){

        Stack<Character> stk = new Stack<>();

        for(int i=0; i<=getLastIndex(s); i++)
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

        String c1AsStr = getString(c1);
        String c2AsStr = getString(c2);

        String opening = "{([";
        int indexOfC1 = opening.indexOf(c1AsStr);

        String closing = "})]";
        int indexOfC2 = closing.indexOf(c2AsStr);

        boolean isNoMatch = false;
        if(indexOfC1 != indexOfC2)
            isNoMatch = true;

        return isNoMatch;
        
    }

    private static String getString(char c){
        return Character.toString(c);
    }
    public static int[] BubbleSort(int[] list){

        int n = list.length;
        boolean flag = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<=(n-i-2);j++){
                if(list[j] > list[j+1]){
                    swap(list, j, j + 1);
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        return list;
    }

    private static void swap(int[] list,int i,int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
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

    public static int[] MergeSort(int [] arry){

        int size = arry.length;
        if(size < 2)
            return arry;

        int mid = size/2;
        int [] left = new int [mid];
        int [] right = new int [size - mid];

        System.arraycopy(arry, 0, left, 0, mid);
        System.arraycopy(arry,mid,right,0,size - mid);

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
