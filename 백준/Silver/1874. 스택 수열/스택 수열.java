import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int number = 1;
        boolean possible = true;
        List<Character> answer = new ArrayList<>();
        for (int target : arr) {
            while (number <= target) {
                stack.offerFirst(number);
                answer.add('+');
                number++;
            }
            if (stack.isEmpty()) {
                possible = false;
                break;
            }
            int top = stack.pollFirst();
            answer.add('-');
            if (top != target) {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (Character c : answer) {
                bw.write(c + "\n");
            }
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

