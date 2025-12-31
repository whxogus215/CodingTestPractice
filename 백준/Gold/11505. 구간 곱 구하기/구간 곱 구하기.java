import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final Long DIV = 1_000_000_007L;
    
    private static long[] tree;
    private static int offset;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int length = N;
        int depth = 0;
        while(length != 0) {
            length /= 2;
            depth += 1;
        }

        offset = (int) (Math.pow(2, depth));
        tree = new long[2 * offset];
        Arrays.fill(tree, 1L);
        for(int i = 0; i < N; i++) {
            tree[offset + i] = sc.nextLong();
        }

        // 세그먼트 트리 초기화
        initialize();

        for(int i = 1; i <= M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if (a == 1) {
                // b번째 수를 c로 변경
                change(b, c);
            } else {
                // b부터 c까지의 곱을 출력
                printMulti(b, (int) c);
            }
        }
    }

    private static void initialize() {
        for(int i = tree.length - 1; i > 1; i--) {
            tree[i / 2] = tree[i / 2] * tree[i] % DIV;
        }
    }
    
    private static void change(int b, long c) {
        int startIdx = offset + b - 1; 
        tree[startIdx] = c;
        while(startIdx > 1) {
            startIdx /= 2;
            tree[startIdx] = (tree[startIdx * 2 + 1] * tree[startIdx * 2]) % DIV;
        }
    }

    private static void printMulti(int b, int c) {
        int startIdx = offset + b - 1;
        int endIdx = offset + c - 1;
        long result = 1;
        while(startIdx <= endIdx) {
            if (startIdx % 2 == 1) {
                result = result * tree[startIdx] % DIV;
            }
            if (endIdx % 2 == 0) {
                result = result * tree[endIdx] % DIV;
            }
            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        System.out.println(result);
    }
}
