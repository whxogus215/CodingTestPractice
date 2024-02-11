package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();

        /**
         * 처음부터 예외 케이스를 생각하기엔 어려울 수 있다.
         * 따라서 일단 핵심기능을 구현하고, 테스트 케이스를 통과하면서 예외 케이스를 하나씩 만들어가면 되는 것이다.
         */
        if (digits.isEmpty()) {
            return result;
        }
        DFS(digits, result, map, 0, new StringBuilder());
        return result;
    }

    public void DFS(String digits, List<String> result, Map<Character, List<Character>> map, int index,
                            StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return ;
        }
        for (Character ch : map.get(digits.charAt(index))) {
            // 각 단계로 들어가면서 탐색을 하는 것과 같다. (DFS)
            /**
             * 매개변수로 전달하는 StringBuilder는 단계를 지날 때마다 새로운 문자가 추가되기 때문에 매번 새로운 인스턴스로 생성해야 한다.
             * 매번 값을 지우거나 초기화하는 것보다 아예 새로운 인스턴스로 생성하는 것이 훨씬 간편하다.
             */

                    DFS(digits, result, map, index + 1, new StringBuilder(path).append(ch));
        }
    }
}
