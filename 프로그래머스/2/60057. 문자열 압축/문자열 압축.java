import java.util.*;

class Solution {
    
    public int solution(String s) {
        int minLength = s.length();
        
        int strLength = s.length();
        StringBuilder sb;
        for(int len = 1; len <= strLength / 2; len++) {
            sb = new StringBuilder();
            String key = s.substring(0, len);
            int compressCount = 1;
            for(int i = len; i < strLength; i += len) {
                String next = s.substring(i, Math.min(i + len, strLength));
                if (next.equals(key)) {
                    compressCount++;
                } else {
                    if (compressCount > 1) {
                        sb.append(compressCount);
                        compressCount = 1;
                    }
                    sb.append(key);
                    key = next;
                }
            }
            if (compressCount > 1) {
                sb.append(compressCount);
                compressCount = 1;
            }
            sb.append(key);
            
            minLength = Math.min(minLength, sb.length());
        }
        
        return minLength;
    }
}