import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        printHello(N);
    }

    public static void printHello(int N) { // 1번부터 N번까지 Hello World를 출력
        if (N == 0) {
            return ;
        }
        printHello(N - 1); // 1번부터 N-1번까지 Hello World를 출력
        System.out.println("HelloWorld");
    }
}