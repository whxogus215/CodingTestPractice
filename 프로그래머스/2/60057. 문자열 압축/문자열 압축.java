class Solution {
    public int solution(String s) {
        int minLength = s.length();
        for(int n = 1; n <= s.length() / 2; n++) {
            StringBuilder sb = new StringBuilder();
            int matchNumber = 1;
            int idx = 0;
            String key = s.substring(idx, idx + n);
            for(int i = idx + n; i < s.length(); i += n) {
                String next = s.substring(i, Math.min(i + n, s.length()));
                if (key.equals(next)) {
                    matchNumber++;
                } else {
                    if (matchNumber > 1) {
                        sb.append(matchNumber);
                    }
                    sb.append(key);
                    matchNumber = 1;
                    key = next;
                }
            }
            if (matchNumber > 1) {
                sb.append(matchNumber);
            }
            sb.append(key);
            minLength = Math.min(minLength, sb.length());
        }
        
        return minLength;
    }
}