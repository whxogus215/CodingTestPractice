import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static long[] tree;
    private static int offset;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int value = 0;
        int length = N;
        while(length != 0) {
            length /= 2;
            value++;
        }
        int limit = (int) (Math.pow(2, value));
        tree = new long[2 * limit];
        offset = limit;
        for(int i = 0; i < N; i++) {
            // 세그먼트 트리의 리프노드에 저장하기
            tree[offset + i] = sc.nextLong();
        }

        // 세그먼트 트리 구간합 초기화
        for(int i = tree.length - 1; i > 1; i--) {
            tree[i / 2] += tree[i];            
        }

        for(int i = 1; i <= M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if (a == 1) {
                // b번째 수를 c로 바꾼다
                change(b, c);
            } else { // a == 2
                // b부터 c까지의 구간합을 출력한다
                getPrefixSum(b, (int) c);
            }
        }
    }

    private static void change(int b, long c) {
        int idx = offset + b - 1;
        long value = c - tree[idx];
        tree[idx] = c;
        while(idx > 1) {
            tree[idx / 2] += value;
            idx /= 2;
        }
    }

    private static void getPrefixSum(int b, int c) {
        int startIdx = offset + b - 1;
        int endIdx = offset + c - 1;
        long sum = 0;
        while (startIdx <= endIdx) {
            if (startIdx % 2 == 1) {
                sum += tree[startIdx];
            }
            if (endIdx % 2 == 0) {
                sum += tree[endIdx];
            }
            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        System.out.println(sum);
    }
}
