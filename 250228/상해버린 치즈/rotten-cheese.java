import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
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

        // 먹은 시간 순서대로 정렬
        Collections.sort(eatInfos, (a, b) -> a.t - b.t);

        List<Info> sickInfos = new ArrayList<>();
        for(int i = 0; i < S; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            sickInfos.add(new Info(p, t));
        }

        int maxPills = 0;
        for(int ch = 1; ch <= M; ch++) {
            boolean isRight = true;
            Set<Integer> sickPeople = new HashSet<>();
            boolean[] isChecked = new boolean[N + 1];
            A:for(Info eatInfo : eatInfos) {
                int cheese = eatInfo.m;
                int person = eatInfo.p;
                int eatTime = eatInfo.t;
                if (cheese != ch) {
                    continue;
                }
                for(Info sickInfo : sickInfos) {
                    if (sickInfo.p != person) {
                        continue;
                    }
                    if (isChecked[sickInfo.p] = false && sickInfo.t <= eatTime) {
                        isRight = false;
                        break A;
                    }
                }
                isChecked[person] = true;
                sickPeople.add(person);
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