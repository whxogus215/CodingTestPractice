import java.util.*;

class Solution {
    
    static class Node {
        int number;
        int sheep;
        int wolf;
        HashSet<Integer> toVisit;
        
        public Node(int number, int sheep, int wolf, HashSet<Integer> toVisit) {
            this.number = number;
            this.sheep = sheep;
            this.wolf = wolf;
            this.toVisit = toVisit;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        ArrayList[] tree = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
        }
        
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(0, 1, 0, new HashSet<>()));
        
        int answer = 0;
        while(!deque.isEmpty()) {
            Node now = deque.poll();
            answer = Math.max(answer, now.sheep);
            
            now.toVisit.addAll(tree[now.number]);
            for(Integer visit : now.toVisit) {
                HashSet<Integer> set = new HashSet<>(now.toVisit);
                set.remove(visit);
                if (info[visit] == 0) { // 탐색 노드가 양일 때
                    deque.offer(new Node(visit, now.sheep + 1, now.wolf, set));
                } else { // 탐색 노드가 늑대일 때
                    if (now.sheep > now.wolf + 1) {
                        deque.offer(new Node(visit, now.sheep, now.wolf + 1, set));
                    }
                }
            }
        }
        
        return answer;
    }
}