package Graph;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n == 1) {
            result.add(List.of(1));
            return result;
        }

        DFS(1,n,k,new ArrayList<>(),result);
        return result;
    }

    public void DFS(int start, int end, int k, List<Integer> arr, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = start; i <= end; i++) {
            arr.add(i);
            DFS(i + 1, end, k - 1, arr, result);
            arr.remove(arr.size() - 1);
        }
    }
}
