import java.util.*;

public class Main {

    public static int GET_SCORE = 1000000;
    public static int Q;
    public static List<Integer> mountains;
    public static List<Mountain> mountainInfos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < Q; i++) {
            String line = sc.nextLine();
            sc.nextLine();
            String[] split = line.split(" ");
            String command = split[0];

            if ("100".equals(command)) {
                int size = Integer.parseInt(split[1]);
                mountains = new ArrayList<>();
                mountainInfos = new ArrayList<>();
                int index = 0;
                for(int j = 2; j < 2 + size; j++) {
                    int height = Integer.parseInt(split[j]);
                    mountains.add(height);
                    mountainInfos.add(new Mountain(index, height));
                    index++;
                }
                Collections.sort(mountainInfos, (m1, m2) -> m2.height - m1.height);
            } else if ("200".equals(command)) {
                Integer newMountain = Integer.parseInt(split[1]); 
                mountains.add(newMountain);
            } else if ("300".equals(command)) {
                mountains.remove(mountains.size() - 1);
            } else {
                int cableIndex = Integer.parseInt(split[1]) - 1;
                playMountain(cableIndex);
            }
        }
    }

    static class Mountain {
        int index;
        int height;

        public Mountain(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void playMountain(int cableIndex) {
        int maxScore = 0;
        for(int start = 0; start < mountains.size() - 1; start++) {
            int finalIndex = start;
            int currentScore = 0;
            if (mountains.get(start) >= mountains.get(start + 1)) {
                continue;
            }
            currentScore += GET_SCORE;
            finalIndex += 1;
            if (start + 1 == cableIndex) {
                // 케이블 높이가 가장 높은 곳을 찾기
                int restart = -1;
                for(Mountain m : mountainInfos) {
                    int index = m.index;
                    int height = m.height;

                    if (index - 1 < 0 || mountains.get(index) <= mountains.get(index - 1)) {
                        continue;
                    }
                    restart = index - 1;
                    break;
                }
                if (restart >= 0) {
                    currentScore += GET_SCORE;
                    finalIndex += 1;
                }
            }
            currentScore += mountains.get(finalIndex);
            maxScore = Math.max(maxScore, currentScore);
        }
        System.out.println(maxScore);
    }
}