import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        Map<Character, Integer> map = new HashMap<>();
        map.put('E', 0);
        map.put('S', 1);
        map.put('W', 2);
        map.put('N', 3);
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int x = 0;
        int y = 0;

        for(int i = 0; i < N; i++) {
            char dir = sc.next().charAt(0);
            int distance = sc.nextInt();

            int index = map.get(dir);

            x += dx[index] * distance;
            y += dy[index] * distance;
        }

        System.out.println(x + " " + y);
    }
}