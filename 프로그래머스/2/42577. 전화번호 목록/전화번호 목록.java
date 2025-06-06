import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        boolean answer = true;
        Set<String> numbers = new HashSet<>();
        A:for(int i = 0; i < phone_book.length; i++) {
            String number = phone_book[i];
            for(int j = number.length(); j >= 1; j--) {
                String subNumber = number.substring(0, j);
                if (numbers.contains(subNumber)) {
                    answer = false;
                    break A;
                }
            }
            numbers.add(number);
        }
        return answer;
    }
}