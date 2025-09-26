import java.util.*;

class Solution {
    
    List<Integer>[] nodes = new ArrayList[1000001];
    Deque<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[1000001];
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // in과 out을 Map으로 저장
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            in.put(edges[i][1], in.getOrDefault(edges[i][1], 0) + 1);
            out.put(edges[i][0], out.getOrDefault(edges[i][0], 0) + 1);
        }
        
        for(Integer key : out.keySet()) {
            if (out.get(key) >= 2 && in.getOrDefault(key, 0) == 0) {
                answer[0] = key;
                break;
            }
        }
        
        for(int i = 0; i < edges.length; i++) {
            int outNode = edges[i][0];
            int inNode = edges[i][1];
            
            if (nodes[outNode] == null) {
                nodes[outNode] = new ArrayList<>();
            }
            nodes[outNode].add(inNode);
        }
        
        for(int i = 0; i < edges.length; i++) {
            if (edges[i][0] == answer[0]) {
                int cycleCount = findCycleCount(edges[i][1]);
                if (cycleCount == 1) {
                    answer[1]++;
                } else if (cycleCount == 2) {
                    answer[3]++;
                }
            }
        }
        answer[2] = out.get(answer[0]) - (answer[1] + answer[3]);
        
        return answer;
    }
    
    private int findCycleCount(int start) {
        queue.add(start);
        visited[start] = true;
        int count = 0;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (nodes[current] == null) {
                continue;
            }
            for(int next : nodes[current]) {
                if (visited[next]) {
                    count++;
                    continue;
                }
                queue.add(next);
                visited[next] = true;
            }
        }
        queue.clear();
        return count;
    }
}