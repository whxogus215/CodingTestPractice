package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1924 {

    static int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    static String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < month - 1; i++) {
            result += months[i];
        }
        result += day; // 입력한 날짜의 모든 일 수가 구해짐

        System.out.println(days[result % 7]);
    }
}
