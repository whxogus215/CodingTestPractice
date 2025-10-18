import java.util.*;

class Solution {
    
    private int[][] dice;
    private int[] answer;
    private int maxWins = 0;
    
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        answer = new int[dice.length / 2];
        
        doCombination(1, 0, new ArrayList<>());
        
        return answer;
    }
    
    private void doCombination(int current, int depth, List<Integer> combi) {
        if (depth == dice.length / 2) {
            // A의 주사위 조합을 모두 구함.
            calculateWins(combi);
            return ;
        }
        for(int i = current; i <= dice.length; i++) {
            combi.add(i);
            doCombination(i + 1, depth + 1, combi);
            combi.remove(combi.size() - 1);
        }
        return ;        
    }
    
    private void calculateWins(List<Integer> aCombi) {
        List<Integer> bCombi = new ArrayList<>();
        for(int i = 1; i <= dice.length; i++) {
            if (!aCombi.contains(i)) {
                bCombi.add(i);   
            }
        }
        
        List<Integer> aSums = new ArrayList<>();
        calculateSums(0, 0, aCombi, aSums);
        
        List<Integer> bSums = new ArrayList<>();
        calculateSums(0, 0, bCombi, bSums);
        
        Collections.sort(bSums);
        
        int totalWins = 0;
        for(int sum : aSums) {
            int low = 0;
            int high = bSums.size() - 1;
            int idx = 0;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                
                if (bSums.get(mid) < sum) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            totalWins += idx + 1;
        }
        
        if (totalWins > maxWins) {
            for(int i = 0; i < answer.length; i++) {
                answer[i] = aCombi.get(i);
            }
            maxWins = totalWins;
        }
    }
    
    private void calculateSums(int depth, int total, List<Integer> combi, List<Integer> sums) {
        if (depth == dice.length / 2) {
            sums.add(total);
            return ;
        }
        int round = combi.get(depth);
        for(int face : dice[round - 1]) {
            calculateSums(depth + 1, total + face, combi, sums);
        }
        return ;
    }
    
    // N개 중 N/2개의 조합을 고른다.
        // 각 조합마다 A와 B의 주사위 합을 모두 구한다.
        // A의 합 요소마다 B에 대해 이분탐색을 수행한다.
        // A의 요소보다 작은 위치가 나오는 최대지점을 구하고 거기에 1을 더한다.
        // 총 승수가 기존 최대 값보다 크다면 값을 갱신한다.
}