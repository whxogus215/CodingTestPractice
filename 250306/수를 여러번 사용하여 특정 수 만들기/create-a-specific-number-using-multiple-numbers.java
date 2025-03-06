import java.util.Scanner;

public class Main {
    public static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int ans = 0;

        // a를 몇 회 사용할지 전부 시도해 봅니다.
        // 모든 경우의 수에 대해 최대가 되도록 하는 수를 계산합니다.
        for(int i = 0; i * a <= c; i++) {
            // a를 i회 사용합니다.
            int cnt = a * i;

            // 값을 최대로 하기 위해 b를 몇회 사용해야 하는지 계산합니다.
            int numB = (c - cnt) / b;

            cnt += numB * b;
            
            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}
