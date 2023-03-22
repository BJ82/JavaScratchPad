package org.Utils;

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

}
