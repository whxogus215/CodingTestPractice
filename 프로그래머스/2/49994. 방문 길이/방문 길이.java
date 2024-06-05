import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * 1. U/D/R/L에 대한 이동 좌표 값을 저장한다.
     * 2. dirs의 각 문자를 바탕으로 새로운 좌표 값을 계산한다.
     * 3. 해당 좌표 값이 경계를 넘어가는지 확인한다.
     * 4. 해당 좌표 값에 대한 정보를 출발점과 목적점을 교차해서 두 번 추가한다.
     * 5. 추가된 좌표의 길이 / 2를 반환한다.
     */

    /**
     * 핵심 포인트
     * 1-1. 중복 확인하는 로직을 구현하는 대신 Set 자료구조를 활용하였다.
     * 1-2. Map과 Point 클래스를 생성해서 Key - Value 형식으로 저장하는 대신 문자열을 만들어서 문자열 비교를 해버림. (중복 확인 편리)
     */

    private static final Map<Character, int[]> location = new HashMap<>();
    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }

    private static boolean isValidLocation(int nx, int ny) {
        return -5 <= nx && nx <= 5 && -5 <= ny && ny <= 5;
    }

    public int solution(String dirs) {
        initLocation();
        int x = 0, y = 0;
        Set<String> answer = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            // nx와 ny가 경계에서 벗어나는지 확인하는 기능 필요 + 경계에서 벗어날 경우 continue;
            if (!isValidLocation(nx, ny)) {
                continue;
            }

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }
        return answer.size() / 2;
    }
}
