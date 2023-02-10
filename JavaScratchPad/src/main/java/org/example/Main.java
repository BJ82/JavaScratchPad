package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Is Palindrome:"+isPalindrome(121));
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