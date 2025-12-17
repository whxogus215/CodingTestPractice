class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cursor = 1;
        for(int station : stations) {
            int start = station - w;
            int end = station + w;
            if (cursor >= start) {
                cursor = end + 1;
                continue;
            }
            int distance = start - cursor;
            answer += (distance / (2 * w + 1) + (distance % (2 * w + 1) != 0 ? 1 : 0));
            cursor = end + 1;
        }
        
        if (cursor <= n) {
            int distance = n - cursor + 1;
            answer += (distance / (2 * w + 1) + (distance % (2 * w + 1) != 0 ? 1 : 0));
        }
        
        return answer;
    }
}