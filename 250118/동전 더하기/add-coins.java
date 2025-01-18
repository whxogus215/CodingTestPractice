import java.util.*;

public class Main {
    
    public static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = n - 1; i >= 0; i--) {
            while (k >= coins[i]) {
                k -= coins[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

// 아하! 가장 금액이 큰 동전을 최대한 쓰면 되겠다!
