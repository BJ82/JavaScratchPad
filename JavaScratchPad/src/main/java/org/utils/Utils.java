package org.utils;

import org.Interfaces.List;
import org.LinkList.Node;
import org.Stack.Stack;

import java.util.*;

public class Utils {
    private Utils() {

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
        return Integer.toString(i);
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


    public static void bubbleSort(int[] list){

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

    public static void insertionSort(int[] list){

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

    public static void selectionSort(int[] list){
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

    public static void mergeSort(Integer [] arry){

        int size = getSize(arry);
        if(size < 2)
            return;

        int mid = size/2;
        Integer [] left = new Integer [mid];
        Integer [] right = new Integer [size - mid];

        copyArray(arry, 0, left, 0, mid);
        copyArray(arry,mid,right,0,size - mid);

        mergeSort(left);
        mergeSort(right);

        merge(left,right,arry);

    }

    public static void merge(Integer [] left, Integer [] right, Integer [] arry){

        int leftArrySize = getSize(left);
        int rightArrySize = getSize(right);

        int leftIdx = 0;
        int rightIdx = 0;
        int arryIdx = 0;

        while(leftIdx < leftArrySize && rightIdx < rightArrySize){

            if(left[leftIdx] < right[rightIdx]){

                arry[arryIdx] = left[leftIdx];
                leftIdx++;
            }

            else if(right[rightIdx] < left[leftIdx]){

                arry[arryIdx] = right[rightIdx];
                rightIdx++;
            }
            arryIdx++;
        }


        if(leftIdx < leftArrySize)
            copyArray(left, leftIdx, arry, arryIdx, leftArrySize-leftIdx);


        if(rightIdx < rightArrySize)
            copyArray(right,rightIdx,arry,arryIdx,rightArrySize-rightIdx);

    }



    public static void copyArray(Integer[] from,int fromIdx,Integer[] to,int toIdx,int length){
        System.arraycopy(from, fromIdx, to, toIdx, length);
    }

    public static Map<Integer,Integer> currencyCount(int amt){
        Map<Integer, Integer> count = new LinkedHashMap<>();
        int[] notes = new int[]{ 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
        for(int i=0;i<9;i++){

            if(amt >= notes[i]){
                count.put(notes[i],amt/notes[i]);
                amt = amt % notes[i];
            }
        }
        return count;
    }

    public static int firstMissingPositive(int[] nums) {

        nums =  Arrays.stream(nums).distinct().sorted().toArray();
        int firstMissingPostv = 0;
        boolean foundOne = false;
        for(int k=0; k<nums.length; k++){

            firstMissingPostv = nums[k];
            if(firstMissingPostv == 1)
                foundOne = true;

            if(foundOne && isLessThanEqual(k,nums.length - 2)
                    && isNotEqual(++firstMissingPostv,nums[k+1])){

                return firstMissingPostv;
            }
        }

        if(!foundOne)
            return 1;
        else
            return ++firstMissingPostv;

    }
    public static boolean isNotEqual(int a,int b){
        return a != b ;
    }

    public static boolean isLessThanEqual(int a,int b){
        return a <= b;
    }
    public static Node<Integer> deleteEven(Node<Integer> head){

        Node<Integer> listHeadOdd = null;
        Node<Integer> currentOdd = null;

        Node<Integer> current = head;
        while(current != null){

            if(isOddNode(current)){

                if(listHeadOdd == null){
                    listHeadOdd = current;
                    currentOdd = listHeadOdd;
                }
                else{
                    currentOdd.setNext(current);
                    currentOdd = currentOdd.getNext();
                }
            }

            current = current.getNext();
        }
        return listHeadOdd;
    }

    public static boolean isEvenNode(Node<Integer> n){

        int data = n.getData();
        return  data % 2 == 0;
    }

    public static boolean isOddNode(Node<Integer> n){
        return !isEvenNode(n);
    }
}


