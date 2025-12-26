import java.util.*;

class Solution {
    
    private final int FRIEND_MAX = 9; 
    private int needFriendCount = FRIEND_MAX;
    
    private int[] dist;
    private int[] weak;
    private int[] weakExpanded;
    private boolean[] visited;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.weak = weak;
        this.dist = dist;
        
        // 원형 배열을 선형 배열로 변환
        this.weakExpanded = new int[2 * weak.length];
        for(int i = 0; i < weak.length; i++) {
            weakExpanded[i] = weak[i];
            weakExpanded[i + weak.length] = weak[i] + n;
        }
        
        // 순열 -> 각 순열마다 완전탐색하기
        this.visited = new boolean[dist.length];
        dfs(new int[dist.length], 0);
        
        if (needFriendCount == FRIEND_MAX) {
            return -1;
        }
        return needFriendCount;
    }
    
    private void dfs(int[] result, int depth) {
        if (depth == dist.length) {
            simulate(result);
            return ;
        }
        for(int i = 0; i < dist.length; i++) {
            if (visited[i]) {
                continue;
            }
            result[depth] = dist[i];
            visited[i] = true;
            dfs(result, depth + 1);
            visited[i] = false;
        }
    }
    
    private void simulate(int[] friendOrder) {
        for(int start = 0; start < weak.length; start++) {
            int cursor = start;
            int friendCount = 0;
            for(int i = 0; i < friendOrder.length; i++) {
                int end = weakExpanded[cursor] + friendOrder[i];
                while(cursor < weakExpanded.length && weakExpanded[cursor] <= end) {
                    cursor++;
                }
                friendCount++;
                if (cursor - start >= weak.length) {
                    needFriendCount = Math.min(needFriendCount, friendCount);
                    break;
                }
            }
        }
    }
}