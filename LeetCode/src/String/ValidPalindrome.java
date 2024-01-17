package String;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        /**
         * 1. 양 끝에 있는 투 포인터
         * 2. 각 문자가 영숫자인지 확인 -> 소문자로 변경
         * 3. 같지 않으면 false 반환
         */
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                // 둘 다 영숫자일 때만 비교하도록 else문에 작성!
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        // 해당 루프를 다 돌았다면 같은 팰린드롬인 것으로 간주!
        return true;
    }

    public static boolean isPalindromeUsingRegex(String s) {
        /**
         * 1. replaceAll(정규식) 사용 -> [^A-Za-z0-9]인 경우 "" 처리
         * 2. reverse()한 문자열과 서로 비교
         */
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        return s_filtered.equals(s_reversed);
    }
}
