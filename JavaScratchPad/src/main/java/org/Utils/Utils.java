package org.Utils;

import org.Interfaces.List;
import org.LinkList.Node;
import org.Stack.Stack;

import java.util.*;

public class Utils {

    public static <T> void printToConsole(List<T> list){

        if(isNull(list))
            return;

        if(isNull(list.getHead())){
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

    public static <T> void printToConsole(Map<T,T> map){

        map.forEach((key,value)-> System.out.println(key+" : "+value));
    }

    public static <T> void printToConsole(T [] arry){

        if(isNull(arry))
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

    private static String intToString(int i){
        return Integer.valueOf(i).toString();
    }

    public static boolean isPalindrome(String str){

        if(isNull(str) || str.isEmpty())
            return false;

        return checkIfPalindrome(str,0,getLastIndex(str));
    }

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

    public static boolean isNull(Object o){
        return null == o;
    }

    private static int getLastIndex(String s){
        return s.length()-1;
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

    public static int countOccurence(String orgnlStr,String subStr){
        String[] orgnlStrAsArry = orgnlStr.split(subStr);
        trim(orgnlStrAsArry);

        String modfdStr = getString(orgnlStrAsArry);
        int lenModfdStr = modfdStr.length();
        int lenOrgnlStr = orgnlStr.length();
        int lenSubStr = subStr.length();
        return (lenOrgnlStr-lenModfdStr)/lenSubStr;
    }

    private static void trim(String [] strArry){
        for(int i=0;i<strArry.length;i++){
            strArry[i] = strArry[i].trim();
        }
    }
    private static String getString(String [] strArry){
        return String.join(" ",strArry);
    }
    private static boolean isOpening(char c){

        String opening = "{([";

        return opening.contains(Character.toString(c));
    }

    private static boolean isClosing(char c){
        String closing = "})]";

        return closing.contains(Character.toString(c));
    }

    private static String getString(char c){
        return Character.toString(c);
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


    public static void BubbleSort(int[] list){

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
    }

    private static void swap(int[] list,int i,int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void InsertionSort(int[] list){

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
    }

    public static void SelectionSort(int[] list){
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
    }

    public static <T> int getSize(T[] arry){
        return arry.length;
    }

    public static void MergeSort(Integer [] arry){

        int size = getSize(arry);
        if(size < 2)
            return;

        int mid = size/2;
        Integer [] left = new Integer [mid];
        Integer [] right = new Integer [size - mid];

        copyArray(arry, 0, left, 0, mid);
        copyArray(arry,mid,right,0,size - mid);

        MergeSort(left);
        MergeSort(right);

        Merge(left,right,arry);

    }

    public static void Merge(Integer [] left,Integer [] right,Integer [] Arry){

        int leftArrySize = getSize(left);
        int rightArrySize = getSize(right);

        int leftIdx = 0;
        int rightIdx = 0;
        int arryIdx = 0;

        while(leftIdx < leftArrySize && rightIdx < rightArrySize){

            if(left[leftIdx] < right[rightIdx]){

                Arry[arryIdx] = left[leftIdx];
                leftIdx++;
            }

            else if(right[rightIdx] < left[leftIdx]){

                Arry[arryIdx] = right[rightIdx];
                rightIdx++;
            }
            arryIdx++;
        }


        if(leftIdx < leftArrySize)
            copyArray(left, leftIdx, Arry, arryIdx, leftArrySize-leftIdx);


        if(rightIdx < rightArrySize)
            copyArray(right,rightIdx,Arry,arryIdx,rightArrySize-rightIdx);

    }



    public static void copyArray(Integer[] from,int fromIdx,Integer[] to,int toIdx,int length){
        System.arraycopy(from, fromIdx, to, toIdx, length);
    }

    public static Map<Integer,Integer> currencyCount(int amt){
        Map<Integer, Integer> count = new LinkedHashMap<Integer, Integer>();
        int[] notes = new int[]{ 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
        for(int i=0;i<9;i++){

            if(amt >= notes[i]){
                count.put(notes[i],amt/notes[i]);
                amt = amt-notes[i];
            }
        }
        return count;
    }
}
