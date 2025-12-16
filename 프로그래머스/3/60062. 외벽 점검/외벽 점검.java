import java.util.*;

class Solution {
    
    private static final int MAX = Integer.MAX_VALUE;
    private int minCount = MAX;
    private int n;
    private int[] weak;
    private int[] dist;
    private int[] weakExpanded;
    private boolean[] visited;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        this.weakExpanded = new int[weak.length * 2];
        this.visited = new boolean[dist.length];
        
        for(int i = 0; i < weak.length; i++) {
            weakExpanded[i] = weak[i];
            weakExpanded[i + weak.length] = weak[i] + n;
        }
        
        dfs(0, new int[dist.length]);
        
        if (minCount == MAX) {
            return -1;
        }
        return minCount;
    }
    
    private void dfs(int depth, int[] result) {
        if (depth == dist.length) {
            simulate(result);            
            return ; 
        }
        
        for(int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = dist[i];
                dfs(depth + 1, result);
                visited[i] = false;
            }
        }
    }
    
    private void simulate(int[] friendOrder) {
        for(int start = 0; start < weak.length; start++) {
            int cursor = start;
            int searchCount = 0;
            for(int i = 0; i < friendOrder.length; i++) {
                int end = weakExpanded[cursor] + friendOrder[i];
                while (cursor < weakExpanded.length && weakExpanded[cursor] <= end) {
                    searchCount++;
                    cursor++;
                }
                if (searchCount >= weak.length) {
                    minCount = Math.min(minCount, (i + 1));
                    break;
                }
            }
        }
    }
}

// 각 순열에 대해 취약점 각 부분을 시작점으로 하여 시뮬레이션 -> 최소 값 갱신