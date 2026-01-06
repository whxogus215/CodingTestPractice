import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int MOD = 1_000_000_007;
    private static long[] tree;
    private static int offset;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int length = N;
        int depth = 0;
        while(length > 0) {
            length /= 2;
            depth += 1;
        }
        offset = (int) (Math.pow(2, depth));
        tree = new long[2 * offset];
        Arrays.fill(tree, 1);
        for(int i = 0; i < N; i++) {
            tree[i + offset] = sc.nextInt();
        }
        
        // 세그먼트 트리 초기화
        for(int i = tree.length - 1; i > 1; i--) {
            tree[i / 2] = (tree[i / 2] * tree[i]) % MOD;
        }

        for(int i = 1; i <= M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 1) {
                change(b, c);
            } else {
                print(b, c);
            }
        }
    }

    private static void change(int pos, int value) {
        int idx = offset + pos - 1;
        tree[idx] = value;
        while(idx > 1) {
            idx /= 2;
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % MOD;
        }
    }

    private static void print(int from, int to) {
        int start = offset + from - 1;
        int end = offset + to - 1;
        long sum = 1;
        while(start <= end) {
            if (start % 2 == 1) {
                sum = (sum * tree[start]) % MOD;
            }
            if (end % 2 == 0) {
                sum = (sum * tree[end]) % MOD;
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        System.out.println(sum);
    }
}
