package Backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15947 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        printNthWord(N);
        System.out.println(sb);
    }

    private static void printNthWord(int N) {
        int countOfRu = N / 14;  // 출력할 ru의 개수
        int orderNum = N % 14; // 총 14개의 단어 중 출력되는 단어 찾는 변수
        if(orderNum == 1 || orderNum == 13)
            sb.append("baby");
        else if(orderNum == 2 || orderNum == 0)
            sb.append("sukhwan");
        else if(orderNum == 5)
            sb.append("very");
        else if(orderNum == 6)
            sb.append("cute");
        else if(orderNum == 9)
            sb.append("in");
        else if(orderNum == 10)
            sb.append("bed");
        else if(orderNum % 4 == 0){
            if (countOfRu >= 4) {
                sb.append("tu+ru*").append(countOfRu + 1);
            } else {
                sb.append("turu");
                for (int i = 0; i < countOfRu; i++) {
                    sb.append("ru");
                }
            }
        } else if (orderNum == 3 || orderNum == 7 || orderNum == 11) {
            if (countOfRu >= 3) {
                sb.append("tu+ru*").append(countOfRu + 2);
            } else {
                sb.append("tururu");
                for (int i = 0; i < countOfRu; i++) {
                    sb.append("ru");
                }
            }
        }
    }
}
