import java.util.*;

public class Main {
    
    private static char[] arr = new char[10001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int maxIndex = -1;
        for(int i = 0; i < N; i++) {
            int index = sc.nextInt();
            char alphabet = sc.next().charAt(0);
            arr[index] = alphabet;
            maxIndex = Math.max(maxIndex, index);
        }

        int maxScore = 0;
        for(int i = 1; i <= maxIndex; i++) {
            int totalScore = 0;
            for(int j = i; j <= i + K; j++) {
                if (arr[j] == 'G') {
                    totalScore += 1;
                }
                if (arr[j] == 'H') {
                    totalScore += 2;
                }
            }
            maxScore = Math.max(maxScore, totalScore);
        }

        System.out.println(maxScore);
    }
}


// 1번부터 16번까지 배열 생성
// 실제 구간의 크기는 K + 1