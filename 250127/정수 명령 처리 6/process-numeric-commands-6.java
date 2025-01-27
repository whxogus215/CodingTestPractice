import java.util.*;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < N; i++) {
            String[] line = sc.nextLine().split(" ");
            String order = line[0];

            if (order.equals("push")) {
                pq.add(-Integer.parseInt(line[1]));
            } else if (order.equals("pop")) {
                System.out.println(-pq.poll());
            } else if (order.equals("size")) {
                System.out.println(pq.size());
            } else if (order.equals("empty")) {
                if (pq.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(-pq.peek());
            }
        }
    }
}