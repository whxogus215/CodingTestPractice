import java.util.*;

class Solution {
    private int n;
    private int[] weak;
    private int[] dist;
    private int[] weakExpanded; // 2배로 늘린 취약점 배열
    private boolean[] visited; // 순열 생성용 방문 체크
    private int minCount = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        this.visited = new boolean[dist.length];
        
        // 1. weak 배열 펼치기 (원형 -> 선형)
        // 예: n=12, weak=[1, 5, 6, 10] -> [1, 5, 6, 10, 13, 17, 18, 22]
        int len = weak.length;
        weakExpanded = new int[len * 2];
        for (int i = 0; i < len; i++) {
            weakExpanded[i] = weak[i];
            weakExpanded[i + len] = weak[i] + n;
        }

        // 2. 순열 만들기 시작
        dfs(0, new int[dist.length]);
        
        if (minCount == Integer.MAX_VALUE) return -1;
        return minCount;
    }

    // 순열 생성 (depth: 현재 뽑은 친구 수, result: 친구들의 순서)
    private void dfs(int depth, int[] result) {
        if (depth == dist.length) {
            check(result); // 순열 완성되면 검사!
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = dist[i];
                dfs(depth + 1, result);
                visited[i] = false;
            }
        }
    }

    // 3. 시뮬레이션 로직 (태현님이 가장 고민하던 부분!)
    private void check(int[] friendOrder) {
        
        // 모든 weak 지점을 시작점으로 테스트
        for (int start = 0; start < weak.length; start++) {
            
            int cursor = start; // 현재 점검해야 할 취약점의 인덱스
            int friendIdx = 0; // 투입된 친구 수
            
            // 친구들을 한 명씩 투입
            // 친구를 다 쓰거나, 모든 취약점을 덮을 때까지 반복
            for (int i = 0; i < friendOrder.length; i++) {
                // 이번 친구가 커버할 수 있는 최대 거리
                // (현재 위치의 좌표 + 친구의 이동 거리)
                int coverRange = weakExpanded[cursor] + friendOrder[i];
                
                // 현재 친구가 커버하는 범위 내의 취약점들을 모두 건너뜀
                // cursor가 가리키는 값이 coverRange보다 작거나 같다면 커버된 것임
                while (cursor < weakExpanded.length && weakExpanded[cursor] <= coverRange) {
                    cursor++;
                }
                
                friendIdx++; // 친구 한 명 사용함
                
                // 모든 취약점을 커버했는지 확인
                // (현재 cursor가 start 지점으로부터 weak.length만큼 전진했는지)
                if (cursor - start >= weak.length) {
                    minCount = Math.min(minCount, friendIdx);
                    break; // 이 순열에서 최소값 찾았으니 더 볼 필요 없음 (최적화)
                }
            }
        }
    }
}