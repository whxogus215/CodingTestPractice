import java.util.*;

class Solution {
    
    private int diceNumber;
    private int maxWins = -1;
    private int[] answer;
    private int[][] dice;
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        diceNumber = dice.length;
        // 1. getCombination() : A가 갖는 조합을 구한다.
        // 2. 각 조합에 대한 승리횟수를 계산한다. : calculateWins()
        // 3. 최종 조합을 반환한다.
        
        answer = new int[diceNumber / 2];
        
        getCombination(1, new ArrayList<>());
        
        return answer;
    }
    
    private void getCombination(int start, List<Integer> aCombi) {
        if (aCombi.size() == diceNumber / 2) {
            calculateWins(aCombi); // 구한 조합에 대한 승리횟수 계산
            return ;
        }
        
        for(int i = start; i <= diceNumber; i++) {
            aCombi.add(i);
            getCombination(i + 1, aCombi);
            aCombi.remove(aCombi.size() - 1);
        }
    }
    
    private void calculateWins(List<Integer> aCombi) {
        // bCombi 계산
        List<Integer> bCombi = new ArrayList<>();
        for(int i = 1; i <= diceNumber; i++) {
            if (aCombi.contains(i)) {
                continue;
            }
            bCombi.add(i);
        }
        
        // aSums 계산
        List<Integer> aSums = new ArrayList<>();
        getAllSums(0, 0, aCombi, aSums);
        
        // bSums 계산
        List<Integer> bSums = new ArrayList<>();
        getAllSums(0, 0, bCombi, bSums);
        
        // bSums 정렬
        Collections.sort(bSums);
        
        int currentWins = 0;
        // 모든 aSums에 대해 bSums의 값을 비교 (이진탐색)
        for(int sum : aSums) {
            int low = 0;
            int high = bSums.size() - 1;
            int idx = bSums.size();
            while(low <= high) {
               int mid = low + (high - low) / 2;
               if (bSums.get(mid) < sum) {
                   low = mid + 1;
               } else {
                   idx = Math.min(idx, mid);
                    high = mid - 1;
               }
            }
            currentWins += idx;
        }
        
        if (currentWins > maxWins) {
            maxWins = currentWins;
            for(int i = 0; i < aCombi.size(); i++) {
                answer[i] = aCombi.get(i);
            }
        }
    }
    
    private void getAllSums(int depth, int currentSum, List<Integer> combi, List<Integer> sums) {
        // 주어진 조합에 대한 주사위 합 저장
        if (depth == combi.size()) {
            sums.add(currentSum);
            return ;
        }
        
        int diceIdx = combi.get(depth) - 1;
        for(int face : dice[diceIdx]) {
            getAllSums(depth + 1, currentSum + face, combi, sums);
        }
    }
}