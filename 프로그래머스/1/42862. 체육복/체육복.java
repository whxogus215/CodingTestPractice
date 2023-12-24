import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        /**
        1. stuent 배열을 통해 학생들의 체육복 여부를 값으로 표시한다.
        2. 여벌이 있으면 1, 여벌 없이 본인 것만 있으면 0, 도난당해 체육복을 빌려야하면 -1로 표시한다.
        3. stuent를 돌면서 여벌이 있는 학생일 경우(값이 1) 앞뒤의 학생을 확인해 -1인 학생에게 빌려준다.
        4. 빌려주게 되면 두 학생의 값을 0으로 갱신한다.
        5. 최종으로 for문을 돌아 값이 0 이상인 학생들의 수를 구한다.
        
        그리디 알고리즘인 이유
        1) 그리디는 지금 현재상태의 최선의 방법만을 고려하는 것이다. 이 문제에서의 현재란
        student 반복문에서 참조되는 각각의 요소들에 대한 탐색이다. 즉, 여벌이 있을 때, 근처에
        도난당한 학생이 있다면 반드시 빌려주는 것. 그것이 바로 현재상태에서의 최적의 해이다.
        2) 1)에서 언급한 각각의 최적의 해는 서로에게 영향을 끼치지 않는다. 왜냐하면 이 문제는 최대값을 구하는
        것이기 때문이다. 앞에서 이미 체육복을 다 빌려주었다고 하더라도 최댓값을 구하는 데에는 영향을 주지
        않는다. 따라서 각각의 최적 해가 모여 전체의 최적 해를 만족한다고도 할 수 있다.
        */
        int[] student = new int[n + 2]; // indexOut 예외 발생 방지
        int answer = 0;
        
        for(int l : lost) {
            student[l]--;
        }
        for(int r : reserve) {
            student[r]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if (student[i] == 1) {
                if (student[i-1] == -1) {
                    student[i]--;
                    student[i-1]++;
                } else if (student[i+1] == -1) {
                    student[i]--;
                    student[i+1]++;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if (student[i] >= 0) {
                answer++;
            }
        }
        
        
        return answer;
    }
}