class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int len = 1; len <= s.length() / 2; len++) {
            StringBuilder sb = new StringBuilder();
            String key = s.substring(0, len);
            int matchNumber = 1;
            for(int i = len; i < s.length(); i += len) {
                String next = s.substring(i, Math.min(s.length(), i + len));
                if (next.equals(key)) {
                    matchNumber++;            
                } else {
                    if (matchNumber > 1) {
                        sb.append(matchNumber);
                        matchNumber = 1;
                    }
                    sb.append(key);
                    key = next;
                }
            }
            if (matchNumber > 1) {
                sb.append(matchNumber);
            }
            sb.append(key);
            
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}