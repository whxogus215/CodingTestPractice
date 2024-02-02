package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        /**
         * 스택에 있는 인덱스의 온도와 배열의 온도를 비교
         *
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            /**
             * 75 - 71 - 69 - 72 일 경우, 69와 72의 비교 뿐만 아니라
             * 71과 72의 비교도 이루어져야 하기 때문에 while문을 사용한다.
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i); // 스택에서 남아있는 인덱스들은 비교적 높은 온도를 만나지 못했기 때문 따라서 answer[i] = 0으로 남아있게 됨(별도 처리X)
        }
        return answer;
    }
}
