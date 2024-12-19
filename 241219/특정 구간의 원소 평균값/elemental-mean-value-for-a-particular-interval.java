import java.util.*;

public class Main {
    
    private static final int MAX_N = 100;
    private static double[] arr = new double[MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                double sum = 0;                
                for(int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                double avg = sum / (j - i + 1);
                if (isContain(avg, i, j)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
        // 시작점과 끝점을 자유롭게 정해야 한다.
        // 시작점과 끝점이 정해진 시점에서 구간 평균 값이 구간의 원소 값에 포함되면 가짓수 1 증가!
        // 각각의 탐색 순회는 서로 다른 가짓수이다.        
    }

    private static boolean isContain(double avg, int start, int end) {
        for(int i = start; i <= end; i++) {
            if (arr[i] == avg) {
                return true;
            }
        }
        return false;
    }
}