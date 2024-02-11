package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * int[]를 List<Integer>로 변환하는 방법 (스트림 사용)
         */
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        DFS(result, new ArrayList<>(), list);
        return result;
    }

    public void DFS(List<List<Integer>> result, List<Integer> prevElements, List<Integer> nums) {
        if (nums.isEmpty()) {
            /**
             * result.add(prevElements)라고 하면 result에 prevElements의 참조 값이 전달된다.
             * 따라서 처음에는 원하는 값이 제대로 들어있을지라도, prevElements의 값이 변하면 result에 저장된
             * 요소에도 영향이 가게된다. 따라서 요소의 값 자체를 저장하기 위해서는 새로운 인스턴스로 생성하여 저장해야 한다.
             */
            result.add(new ArrayList<>(prevElements));
        }
        for (Integer n : nums) {
            List<Integer> nextElements = new ArrayList<>(nums);
            nextElements.remove(n);

            prevElements.add(n);
            DFS(result, prevElements, nextElements);
            prevElements.remove(n);
        }
    }
}
