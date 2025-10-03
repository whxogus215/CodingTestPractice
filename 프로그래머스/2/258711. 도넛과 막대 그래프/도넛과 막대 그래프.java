class Solution {
    
    private final int MAX_N = 1000000;
    
    public int[] solution(int[][] edges) {
        
        int[] in = new int[MAX_N + 1];
        int[] out = new int[MAX_N + 1];
        
        int maxNode = 0;
        for(int i = 0; i < edges.length; i++) {
            out[edges[i][0]]++;
            in[edges[i][1]]++;
            
            maxNode = Math.max(maxNode, Math.max(edges[i][0], edges[i][1]));
        }
        
        int startNode = -1;
        int stickNodeCount = 0;
        int eightNodeCount = 0;
        
        for(int i = 1; i <= maxNode; i++) {
            if (in[i] == 0 && out[i] >= 2) {
                startNode = i;
            } else if (in[i] >= 2 && out[i] == 2) {
                eightNodeCount++;
            } else if (in[i] > 0 && out[i] == 0) {
                stickNodeCount++;
            }
        }
              
        int[] answer = {startNode, out[startNode] - (stickNodeCount + eightNodeCount), stickNodeCount, eightNodeCount};
        
        return answer;
    }
}

// 정점 : 나가는 간선이 2개 이상이고, 들어오는 간선이 없음.
// 그래프의 총 합 : 나가는 간선의 개수
// 막대 : 나가는 간선이 1개이고, 들어오는 간선이 없음.
// 8자 : 나가는 간선이 2개, 들어오는 간선이 2개인 정점이 있음.
// 도넛 : 그래프의 총합 - (막대 + 8자)

// 각 정점별 나가는 간선 개수와 들어오는 간선 개수를 저장
// 2개의 배열