import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> dictionary = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            dictionary.add(s);
        }

        int result = 0;
        for(int i = 0; i < M; i++) {
            String s = sc.next();
            if (dictionary.contains(s)) {
                result++;
            }
        }
        
        System.out.println(result);
    }
}
