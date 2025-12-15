class Solution {
    
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    
    private int n;
    private int[] weak;
    private int[] weakExpanded;
    private int[] dist;
    private boolean[] visited;
    private int minCount = MAX_COUNT;
    
    public int solution(int n, int[] weak, int[] dist) {   
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        this.visited = new boolean[dist.length]; 
        
        this.weakExpanded = new int[weak.length * 2];
        for(int i = 0; i < weak.length; i++) {
            weakExpanded[i] = weak[i];
            weakExpanded[i + weak.length] = weak[i] + n;
        }
        
        dfs(0, new int[dist.length]);
        
        if (minCount == MAX_COUNT) {
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
        
        // 모든 weak 지점에 대해서 출발을 해봐야 함
        for(int start = 0; start < weak.length; start++) {
            int cursor = start;
            int friendCount = 0;
            for(int i = 0; i < friendOrder.length; i++) {
                int currentDist = friendOrder[i];
                int coverage = weakExpanded[cursor] + currentDist;
                
                while (cursor < weakExpanded.length && weakExpanded[cursor] <= coverage) {
                    cursor++;
                }
                friendCount++;
                
                if (cursor - start >= weak.length) {
                    minCount = Math.min(minCount, friendCount);
                    break;
                }
            }
        }
    }
}