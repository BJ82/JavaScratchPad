package org.Utils;

public class Utils {
    public static boolean isPalindrome(int num){
        String strNum = Integer.valueOf(num).toString();
        return checkIfPalindrome(strNum);

    }
    public static boolean isPalindrome(String str){
        return checkIfPalindrome(str);
    }
    private static boolean checkIfPalindrome(String s){
        boolean isPalindrome = false;
        int last=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == s.charAt(last)){
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
