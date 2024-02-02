package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        /**
         * 문자가 몇 번 나오는지 저장하는 자료구조가 필요 - Map
         * 문자를 저장하는 자료구조 - Stack
         * 문자가 한 번만 나와야하기 때문에 이미 처리했는지를 확인하는 자료구조가 필요 - Map
         * 
         * 
         * 스택을 써야하는 이유
         * ex. bcabc
         *
         * a - 1
         * b - 2
         * c - 2
         *
         * b-c-a
         * if (s.charAt(i) < stack.peek())
         *
         */
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

//        for (int i = 0; i < s.length(); i++) {
//            count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
//        }
        for (char c : s.toCharArray()) {
            count.put(c, count.get(c) == null ? 1 : count.get(c) + 1);
        }

        for (char c : s.toCharArray()) {
            count.put(c, count.get(c) - 1);
            if (seen.get(c) != null && seen.get(c)) { // NPE 예외처리
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && count.get(stack.peek()) > 0) { // NPE 예외처리
                seen.put(stack.pop(), false);
            }
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()); // removeLast()는 empty시 예외 발생
        }
        return sb.toString();
    }
}
