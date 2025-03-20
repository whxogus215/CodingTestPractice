import java.util.*;

public class Main {

    public static int K, N;
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        
        permutation(1);
    }

    public static void permutation(int number) {
        if (number == N + 1) {
            for(Integer n : numbers) {
                System.out.print(n + " ");
            }
            System.out.println();
            return ;
        }

        for(int i = 1; i <= K; i++) {
            numbers.add(i);
            permutation(number + 1);
            numbers.remove(numbers.size() -1);
        }
    }
}