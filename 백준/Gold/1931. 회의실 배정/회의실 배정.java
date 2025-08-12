import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            nodes[i] = new Node(start, end);
        }

        Arrays.sort(nodes, (n1, n2) -> {
            if (n1.end == n2.end) {
                return Integer.compare(n1.start,n2.start);
            }
            return Integer.compare(n1.end, n2.end);
        });

        int count = 1; // 첫 번째는 추가했다고 가정
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (nodes[i].start >= nodes[idx].end) {
                idx = i;
                count++;
            }
        }
        System.out.println(count);
    }

    static class Node {

        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
