class Solution {
    
    private int[] weak;
    private int[] dist;
    private int[] expandedWeak;
    private boolean[] visited;
    
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.weak = weak;
        this.dist = dist;
        int weakNum = weak.length;
        expandedWeak = new int[weakNum * 2];
        visited = new boolean[dist.length];
        for(int i = 0; i < weakNum; i++) {
            expandedWeak[i] = weak[i];
            expandedWeak[i + weakNum] = weak[i] + n;
        }
        
        // 각 순열마다 weak 지점을 시작점으로 하는 완전탐색을 수행
        dfs(0, new int[dist.length]);
        
        // 원형을 선형으로 변환
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }
    
    private void dfs(int idx, int[] result) {
        if (idx == dist.length) {
            // 각 조합에 대해 탐색 시작
            search(result);
            return ;
        }
        for(int i = 0; i < dist.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[idx] = dist[i];
            dfs(idx + 1, result);
            visited[i] = false;
        }
    }
    
    private void search(int[] friendOrder) {
        for(int i = 0; i < weak.length; i++) {
            int cursor = i;
            int num = 0;
            for(int j = 0; j < friendOrder.length; j++) {
                int end = expandedWeak[cursor] + friendOrder[j];
                while(cursor < expandedWeak.length && expandedWeak[cursor] <= end) {
                    cursor++;   
                }
                num++;
                if (cursor - i >= weak.length) {
                    answer = Math.min(answer, num);
                    break;
                }
            }
        }
        
    }
}