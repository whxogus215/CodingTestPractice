import java.util.*;

class Solution {
    public int solution(String s) {
        int min = s.length();
        StringBuilder sb;
        for(int keyLength = 1; keyLength <= s.length() / 2; keyLength++) {
            sb = new StringBuilder();
            String key = s.substring(0, keyLength);
            int matchNumber = 1;
            for(int i = keyLength; i < s.length(); i += keyLength) {
                String next;
                if (i + keyLength > s.length()) {
                    next = s.substring(i, s.length());
                } else {
                    next = s.substring(i, i + keyLength);
                }
                if (key.equals(next)) {
                    matchNumber++;
                } else {
                    if (matchNumber > 1) {
                        sb.append(matchNumber);
                    }
                    sb.append(key);
                    key = next;
                    matchNumber = 1;
                }
            }
            if (matchNumber > 1) {
                sb.append(matchNumber);
            }
            sb.append(key);
            min = Math.min(min, sb.length());
        }
        
        return min;
    }
}