package org.Utils;

import java.util.*;

public class Utils {
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

}
