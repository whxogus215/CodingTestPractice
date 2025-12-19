class Solution {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder sb;
        for(int length = 1; length <= s.length() / 2; length++) {
            sb = new StringBuilder();
            String key = s.substring(0, length);
            int idx = length;
            int matchCount = 1;
            for(int i = idx; i < s.length(); i += length) {
                String next = s.substring(i, Math.min(s.length(), i + length));
                if (key.equals(next)) {
                    matchCount++;
                } else {
                    if (matchCount > 1) {
                        sb.append(matchCount);
                    }
                    matchCount = 1;
                    sb.append(key);
                    key = next;
                }
            }
            if (matchCount > 1) {
                sb.append(matchCount);
            }
            sb.append(key);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
