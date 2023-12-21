import java.util.*;

class Main {
  public static HashMap<Character, Integer> map = new HashMap<>();
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    map.put('0', 0);
    map.put('1', 0);

    char target = str.charAt(0);
    for (int i = 1; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (target != ch) {
        map.put(target, map.get(target) + 1);
        target = ch;
      }
    }
    map.put(target, map.get(target) + 1);

    System.out.println(Math.min(map.get('0'), map.get('1')));
  }
}