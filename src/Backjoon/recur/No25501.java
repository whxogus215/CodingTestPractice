package Backjoon.recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No25501 {
    static int count;
    public static int recursion(String s, int l, int r){
        count += 1;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            int result = isPalindrome(br.readLine());
            System.out.printf("%d %d\n",result, count);
        }
    }
}
