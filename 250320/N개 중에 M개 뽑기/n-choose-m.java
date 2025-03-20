import java.util.*;

public class Main {

    public static int N, M;
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        combi(0, 1);
    }

    public static void combi(int index, int start) {
        if (index == M) {
            print();
            return;
        }

        for(int i = start; i <= N; i++) {
            numbers.add(i);
            combi(index + 1, i + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    public static void print() {
        for(Integer n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}