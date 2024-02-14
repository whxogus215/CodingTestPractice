package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    /**
     * 그래프(or 재귀) 문제를 추상화할 때 : 트리 구조 사용해서 각 단계별 로직을 파악해보기!
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void DFS(int[] nums, int index, LinkedList<Integer> arr, List<List<Integer>> result) {
        result.add(new LinkedList<>(arr));
        for (int i = index; i < nums.length; i++) {
            arr.add(nums[i]);
            DFS(nums, i + 1, arr, result);
            arr.removeLast();
        }
    }
}
