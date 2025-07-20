import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offerLast(i);
        }

        while (queue.size() > 1) {
            queue.pollFirst();
            if (queue.size() > 1) {
                queue.offerLast(queue.pollFirst());
            }
        }

        bw.write(queue.pollFirst() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
