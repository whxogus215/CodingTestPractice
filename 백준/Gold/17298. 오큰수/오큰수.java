import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(numbers[i]);
        }

        int[] answer = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peekFirst()] < A[i]) {
                answer[stack.peekFirst()] = A[i];
                stack.pollFirst();
            }
            stack.offerFirst(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pollFirst()] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
