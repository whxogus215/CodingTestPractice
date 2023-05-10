package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        System.out.println(min + " " + max);
    }
}
