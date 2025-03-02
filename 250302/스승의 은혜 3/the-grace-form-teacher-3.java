import java.util.*;

public class Main {
    
    public static int N;
    public static int B;

    public static int[][] budgets;
    public static int[] totals;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextInt();

        budgets = new int[N][2];
        totals = new int[N];
        
        for(int i = 0; i < N; i++) {
            int price = sc.nextInt();
            int delivery = sc.nextInt();

            budgets[i] = new int[]{price, delivery};
            totals[i] = price + delivery;
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            int[] copyTotals = Arrays.copyOf(totals, totals.length);
            
            int price = budgets[i][0];
            int delivery = budgets[i][1];

            int discountTotal = (price / 2) + delivery;
            copyTotals[i] = discountTotal;

            Arrays.sort(copyTotals);

            int totalBudget = B;
            int maxNum = 0;
            for(int j = 0; j < N; j++) {
                if (totalBudget < copyTotals[j]) {
                    break;
                }
                totalBudget -= copyTotals[j];
                maxNum += 1;
            }

            result = Math.max(result, maxNum);
        }

        System.out.println(result);
    }
}