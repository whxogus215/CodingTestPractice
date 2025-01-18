import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if (Math.abs(i - a) <= 2 || Math.abs(j - b) <= 2 || Math.abs(k - c) <= 2) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);        
    }
}


// 각 조합별로 자릿수 연산해서 3이상이면 Continue

