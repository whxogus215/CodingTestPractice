import java.util.Scanner;

public class Main {

    public static final int MAX_LENG = 1000000;
    public static int[] A = new int[MAX_LENG + 1];
    public static int[] B = new int[MAX_LENG + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // n번 만큼 A의 좌표를 1초 단위로 기록
        int totalTime = 0;
        int time = 1;
        int signal = 0;
        for(int i = 0; i < n; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();
            totalTime += t;
            if (d == 'R') {
                signal = 1;
            } else {
                signal = -1;
            }

            while(t-- > 0) {
                A[time] = A[time - 1] + signal;
                time++;
            }
        }
        // m번 만큼 B의 좌표를 1초 단위로 기록
        time = 1;
        for(int i = 0; i < m; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            if (d == 'R') {
                signal = 1;
            } else {
                signal = -1;
            }

            while(t-- > 0) {
                B[time] = B[time - 1] + signal;
                time++;
            }
        }

        int answer = -1;
        // A, B의 총 이동시간이 같으므로 두 배열을 동시에 확인 O(1000)
        for(int i = 1; i <= totalTime; i++) {
            if (A[i] == B[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}