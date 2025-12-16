import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cursor = 1;
        int width = 2 * w + 1;
        
        for(int station : stations) {
            int start = station - w;
            int end = station + w;
            if (cursor < start) {
                int length = start - cursor;
                int count = length / width + (length % width != 0 ? 1 : 0);
                answer += count;
            }
            cursor = end + 1;
        }
        
        if (cursor <= n) {
            int length = n - cursor + 1;
            int count = length / width + (length % width != 0 ? 1 : 0);
            answer += count;
        }
        
        return answer;
    }
}

// 기지국 한 개가 커버할 수 있는 거리 : 2 * w + 1
// 현재 탐색 대상과 가장 가까이 있는 기지국 간의 거리 차 : 전파가 전달되지 않는 곳의 개수
// (2 * w + 1) * cnt >= (전파가 전달되지 않는 곳의 개수)를 만족하는 cnt의 최소 값을 구한 후, 더한다.