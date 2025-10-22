import java.util.*;

class Solution {
    
    private int maxWins = 0;
    private int[][] dice;
    private int[] answer; 
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        answer = new int[dice.length / 2];
        
        createCombination(0, new ArrayList<>());
        
        return answer;
    }
    
    private void createCombination(int idx, List<Integer> result) {
        if (result.size() == dice.length / 2) {
            calculateCombination(result);            
            return ;
        }
        for(int i = idx; i < dice.length; i++) {
            result.add(i);
            createCombination(i + 1, result);
            result.remove(result.size() - 1);
        }
    }
    
    private void calculateCombination(List<Integer> aCombi) {
        List<Integer> bCombi = new ArrayList<>();
        for(int i = 0; i < dice.length; i++) {
            if (!aCombi.contains(i)) {
                bCombi.add(i);
            }
        }
        
        List<Integer> aSum = new ArrayList<>();
        calculateSum(0, 0, aCombi, aSum);
        
        List<Integer> bSum = new ArrayList<>();
        calculateSum(0, 0, bCombi, bSum);
        Collections.sort(bSum);
        
        int totalWins = 0;
        for(int sum : aSum) {
            int low = 0;
            int high = bSum.size() - 1;
            
            while(low <= high) {
                int mid = low + (high - low) / 2;
                
                if (bSum.get(mid) < sum) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            totalWins += low;
        }
        
        if (totalWins > maxWins) {
            maxWins = totalWins;
            for(int i = 0; i < aCombi.size(); i++) {
                answer[i] = aCombi.get(i) + 1;
            }
        }
    }
    
    private void calculateSum(int idx, int total, List<Integer> combi, List<Integer> sum) {
        if (idx == combi.size()) {
            sum.add(total);
            return ;
        }
        int diceIdx = combi.get(idx);
        for(int i = 0; i < dice[diceIdx].length; i++) {
            calculateSum(idx + 1, total + dice[diceIdx][i], combi, sum);
        }
    }
}
