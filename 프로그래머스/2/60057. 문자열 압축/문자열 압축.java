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
                int endIdx = Math.min(s.length(), i + keyLength);
                String next = s.substring(i, endIdx);
                if (key.equals(next)) {
                    matchNumber++;
                } else {
                    sb.append((matchNumber > 1) ? matchNumber + key : key);
                    key = next;
                    matchNumber = 1;
                }
            }
            sb.append((matchNumber > 1) ? matchNumber + key : key);

            min = Math.min(min, sb.length());
        }
        
        return min;
    }
}