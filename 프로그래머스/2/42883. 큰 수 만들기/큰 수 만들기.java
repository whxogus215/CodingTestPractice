import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int len = number.length() - k;
        StringBuilder sb = new StringBuilder();
        
        char[] arr = number.toCharArray();
        
        int start = 0;
        for(int i = 0; i < len; i++) {
            int max = -1;
            for(int j = start; j <= i + k; j++) {
                if (arr[j] - '0' > max) {
                    max = arr[j] - '0';
                    start = j + 1;
                }
            }
            sb.append(Integer.toString(max));
        }
        
        return sb.toString();
    }
}