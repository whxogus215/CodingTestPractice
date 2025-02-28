import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();

        List<Info> eatInfos = new ArrayList<>();
        for(int i = 0; i < D; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            eatInfos.add(new Info(p, m, t));
        }

        List<Info> sickInfos = new ArrayList<>();
        for(int i = 0; i < S; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            sickInfos.add(new Info(p, t));
        }

        int maxPills = 0;
        for(int ch = 1; ch <= M; ch++) {
            Set<Integer> sickPeople = new HashSet<>();
            int[] time = new int[N + 1];
            for(Info eatInfo : eatInfos) {
                int cheese = eatInfo.m;
                int person = eatInfo.p;
                int eatTime = eatInfo.t;
                if (cheese != ch) {
                    continue;
                }
                if (eatTime < time[person]) {
                    time[person] = eatTime;
                } else if (time[person] == 0) {
                    time[person] = eatTime;
                }
                sickPeople.add(person);
            }

            boolean isRight = true;
            for(Info sickInfo : sickInfos) {
                int person = sickInfo.p;
                if (time[person] == 0) {
                    isRight = false;
                }
                if (time[person] >= sickInfo.t) {
                    isRight= false;
                }
            }

            if (isRight) {
                maxPills = Math.max(maxPills, sickPeople.size());
            }
        }

        System.out.println(maxPills);
    }

    static class Info {
        int p;
        int m;
        int t;

        public Info(int p, int m, int t) {
            this.p = p;
            this.m = m;
            this.t = t;
        }

        public Info(int p, int t) {
            this(p, 0, t);
        }
    }
}