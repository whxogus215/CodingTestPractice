import java.util.*;

public class Main {

    public static int N, C, G, H;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        G = sc.nextInt();
        H = sc.nextInt();

        Equipment[] equipments = new Equipment[N];

        int minTa = 1000;
        int maxTb = 0;
        for(int i = 0; i < N; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            minTa = Math.min(minTa, tA);
            maxTb = Math.max(maxTb, tB);

            equipments[i] = new Equipment(tA, tB);
        }

        int maxPower = 0;

        for(int i = minTa; i <= maxTb; i++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                sum += equipments[j].getPower(i);
            }
            maxPower = Math.max(maxPower, sum);
        }

        System.out.println(maxPower);
    }

    static class Equipment {

        int tA;
        int tB;

        public Equipment(int tA, int tB) {
            this.tA = tA;
            this.tB = tB;
        }

        public int getPower(int temp) {
            if (temp < tA) {
                return C;
            } else if (temp >= tA && temp <= tB) {
                return G;
            } else {
                return H;
            }
        }
    }
}