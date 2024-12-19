import java.util.*;

public class Main {

    private static final int MAX_LEN = 100;
    private static int[] arrA = new int[MAX_LEN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arrB = new int[M];

        for(int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < M; i++) {
            arrB[i] = sc.nextInt();
        }
        Arrays.sort(arrB);
        
        int count = 0;
        for(int i = 0; i <= N - M; i++) {
            int[] copy = new int[M];
            int index = 0;
            for(int j = i; j < i + M; j++) {
                copy[index++] = arrA[j];
            }
            Arrays.sort(copy);

            if (Arrays.equals(copy, arrB)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

/**
1. 수열A의 M만큼의 연속되는 구간을 잡아서
   구간 내 원소들이 수열 B의 모든 M개의 수를 포함하는지 확인한다. (수열 B를 오름차순)
2. 일치하되 이전에 나왔던 조합이 아닐 경우, 카운트 ++
**/