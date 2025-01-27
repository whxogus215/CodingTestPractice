import java.util.*;

public class Main {
    
    public static PriorityQueue<Integer> list = new PriorityQueue<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int element = sc.nextInt();
            list.add(element);
        }

        /**
        1. 맨 앞 두 개를 더한 값을 cost에 추가
        2. 맨 앞 두 개를 제거하고 더한 값을 앞에 추가
        3. 오름차순 정렬
        4. 요소 개수가 1개 보다 클 때까지 반복
        **/
        int cost = 0;

        while(list.size() > 1) {
            int a = list.poll();
            int b = list.poll();
            int sum = a + b;

            cost += sum;
            list.add(sum);
        }

        System.out.println(cost);
    }
}