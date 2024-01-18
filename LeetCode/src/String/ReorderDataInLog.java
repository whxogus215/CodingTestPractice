package String;

import java.util.ArrayList;
import java.util.List;

public class ReorderDataInLog {
    public static void main(String[] args) {

    }

    public static String[] reorderLogFiles(String[] logs) {
        /**
         * 식별자와 본문 내용을 분리시킴 -> split()
         * 문자 로그와 숫자 로그를 각각의 리스트에 저장한다.
         * 문자 로그를 오름차순으로 정렬 -> 만약 같을 경우, 식별자로 구분
         */
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log : logs) {
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letters.add(log);
            } else {
                digits.add(log);
            }
        }

        letters.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letters.addAll(digits);

        return letters.toArray(new String[0]);
    }
}
