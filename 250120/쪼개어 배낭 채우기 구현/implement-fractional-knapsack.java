import java.util.*;

public class Main {
    
    public static List<Jewel> jewels = new ArrayList<>();;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            jewels.add(new Jewel(w, v));
        }

        Collections.sort(jewels, (j1, j2) -> {
            double ratio1 = (double) j1.value / j1.weight;
            double ratio2 = (double) j2.value / j2.weight;

            if (ratio1 > ratio2) {
                return -1;
            } else if (ratio1 < ratio2) {
                return 1;
            } else {
                return 0;
            }
        });

        double answer = 0.0;
        for(int i = 0; i < N; i++) {
            int w = jewels.get(i).weight;
            int v = jewels.get(i).value;

            if (M >= w) {
                M -= w;
                answer += v;
            } else {
                answer += (double) M / w * v;
                break;
            }
        }

        System.out.printf("%.3f", answer);
    }

    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}


// 얻을 수 있는 최대 가치 => 최대한 비싼 걸 많이 담으면 된다!
// 쪼개어 담을 수 있기 때문에 "무게 당 가격"이 높은 순으로 담으면 된다!

// 1. 무게 당 가격이 높은 순으로 내림차순 정렬한다. => 정렬 기준은 (가치 / 무게)가 된다. => 객체 정렬
// 2. 첫 번째 요소의 무게와 남아있는 무게를 비교한다.
// 3. 남아있는 무게가 요소의 무게 보다 크거나 같으면 1개를 담는다.
// 4. 남아있는 무게가 요소의 무게보다 작으면 쪼갠다.
// -> (남아있는 무게 / 요소의 무게 = 개수) * 가치를 더한다.
// 소수점 셋째 자리까지 출력한다.