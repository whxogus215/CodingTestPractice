import java.util.*;

class Solution {
    
    private int maxWins = 0;
    private int[] answer;
    
    public int[] solution(int[][] dice) {
        answer = new int[dice.length / 2];
        combination(0, 0, dice, new ArrayList<>());
        return answer;
    }
    
    private void combination(int index, int depth, int[][] dice, List<Integer> result) {
        if (depth == dice.length / 2) {
            calculateWins(dice, result);
            // A와 B의 조합을 모두 구했으므로, 해당 조합에 대한 승수 계산
            return ;
        }
        for(int i = index; i < dice.length; i++) {
            result.add(i);
            combination(i + 1, depth + 1, dice, result);
            result.remove(result.size() - 1);
        }
    }
    
    private void calculateWins(int[][] dice, List<Integer> aCombi) {
        List<Integer> bCombi = new ArrayList<>();
        for(int i = 0; i < dice.length; i++) {
            if (!aCombi.contains(i)) {
                bCombi.add(i);
            }
        }
        
        List<Integer> aSums = new ArrayList<>();
        calculateSums(0, 0, dice, aCombi, aSums);
        
        List<Integer> bSums = new ArrayList<>();
        calculateSums(0, 0, dice, bCombi, bSums);
        
        Collections.sort(bSums);
        
        int totalWins = 0;
        for(int aSum : aSums) {
            int left = 0;
            int right = bSums.size() - 1;
            
            while(left <= right) {
                int mid = left + (right - left) / 2;
                
                if (bSums.get(mid) >= aSum) {        
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            totalWins += left;
        }
        
        if (totalWins > maxWins) {
            maxWins = totalWins;
            for(int i = 0; i < answer.length; i++) {
                answer[i] = aCombi.get(i) + 1;
            }
        }
    }
    
    private void calculateSums(int depth, int total, int[][] dice, List<Integer> combi, List<Integer> sums) {
        if (depth == combi.size()) {
            sums.add(total);
            return ;
        }
        
        int diceNum = combi.get(depth);
        for(int i = 0; i < dice[diceNum].length; i++) {
            calculateSums(depth + 1, total + dice[diceNum][i], dice, combi, sums);
        }
    }
}

// n / 2개의 조합을 구한다.
// 각 조합에 대한 A와 B의 합을 배열로 저장한다.
// A의 각 요소에 대해 B보다 큰 경우의 수를 구한다.
// 총 승수가 큰 조합을 반환한다.