import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        int[] answer = new int[4];
        
        for(int i = 0; i < edges.length; i++) {
            in.put(edges[i][1], in.getOrDefault(edges[i][1], 0) + 1);
            out.put(edges[i][0], out.getOrDefault(edges[i][0], 0) + 1);
        }
        
        for(Integer node : out.keySet()) {
            int count = out.get(node);
            if (count >= 2) {
                if (!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3]++;
                }
            }
        }
        
        for(Integer node : in.keySet()) {
            Integer count = in.get(node);
            if (!out.containsKey(node)) {
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0]) - (answer[2] + answer[3]);
        
        return answer;
    }
}
