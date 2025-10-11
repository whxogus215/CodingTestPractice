import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int num : out.keySet()) {
            if (out.get(num) >= 2) {
                if (!in.containsKey(num)) {
                    answer[0] = num;
                } else {
                    answer[3]++;
                }
            }
        }
        
        for(int num : in.keySet()) {
            if (out.getOrDefault(num, 0) == 0) {
                if (in.get(num) <= 2) {
                    answer[2]++;
                }
            }
        }
        
        answer[1] = out.get(answer[0]) - (answer[2] + answer[3]);
        return answer;
    }
}

// 나가는 간선만 있는 정점
// 8자 : 나가는 간선 2개, 들어오는 간선 2개 이상
// 막대 : 나가는 간선 0개, 들어오는 간선 0개 이상
// 도넛 : 나가는 간선 1개, 들어오는 간선 1개 이상