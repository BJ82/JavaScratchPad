package org.example;

import org.LinkList.LinkList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Is Palindrome:"+isPalindrome(121));

        LinkList llist = new LinkList();
        llist.print();

        for(int i=6;i>=1;i--){
            llist.insert(i);    //
        }

        llist.print();
        llist.reverse();
        System.out.println("After Reversing");
        llist.print();
        System.out.println("Inserting 1000 at index 4");
        llist.insert(1000,4);
        llist.print();
    }

    public static boolean isPalindrome(int num){
        String strNum = Integer.valueOf(num).toString();
        boolean isPalindrome = false;
        int last=strNum.length()-1;
        for(int i=0;i<strNum.length();i++){
            if(strNum.charAt(i) == strNum.charAt(last)){
                if(i<=last)
                    isPalindrome = true;
                last--;
            }
            else{
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}