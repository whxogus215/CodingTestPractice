package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        DFS(candidates, 0, 0, target, new LinkedList<>(), result);
        return result;
    }

    public void DFS(int[] candidates, int start, int sum, int target, LinkedList<Integer> arr, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new LinkedList<>(arr));
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                arr.add(candidates[i]);
                DFS(candidates, i, sum + candidates[i], target, arr, result);
                arr.removeLast();
            }
        }
    }
}
