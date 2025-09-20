import java.util.*;

class Solution {
    
    private static final int MAX = 1000000;
    
    boolean[] visited = new boolean[MAX + 1];
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int[] in = new int[MAX + 1];
        int[] out = new int[MAX + 1];
        List<Integer>[] edge = new LinkedList[MAX + 1];
        for(int i = 1; i <= MAX; i++) {
            edge[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < edges.length; i++) {
            out[edges[i][0]]++;
            in[edges[i][1]]++;
            edge[edges[i][0]].add(edges[i][1]);
        }
        
        for(int i = 1; i <= MAX; i++) {
            if (in[i] == 0 && out[i] >= 2) {
                answer[0] = i;
                break;
            }
        }
        
        for(Integer current : edge[answer[0]]) {
            int count = findCycleCount(current, edge);
            
            if (count == 1) {
                answer[1]++;
            } else if (count == 2) {
                answer[3]++;
            } else {
                answer[2]++;
            }
        }
        
        return answer;
    }
    
    private int findCycleCount(int start, List<Integer>[] edge) {
        int cycleCount = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            Integer now = queue.poll();
            for(Integer next : edge[now]) {
                if (visited[next]) {
                    cycleCount++;
                    continue;
                }
                queue.add(next);
                visited[next] = true;
            }
        }
        
        return cycleCount;     
    }
}
