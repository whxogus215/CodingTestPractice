package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int share = str.length() / 10;
        int bal = str.length() % 10;
        int index = 0;
        for (int i = 0; i < share; i++) {
            System.out.println(str.substring(index, index + 10));
            index += 10;
        }
        System.out.println(str.substring(str.length() - bal));
    }
}
