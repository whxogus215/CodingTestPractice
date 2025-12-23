import java.util.*;

class Node {
    Node[] next = new Node[10];
    boolean isEnd = false;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] phoneNumbers = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = sc.next();
            }

            // 정렬을 하면 접두어 관계인 번호들이 인접하게 되어 처리가 쉽지만,
            // 트라이로 풀기 위해 정렬 없이 로직을 보강합니다.
            Node root = new Node();
            boolean isConsistent = true;

            for (String num : phoneNumbers) {
                if (!isConsistent) continue; // 이미 실패면 트라이 삽입 생략

                Node now = root;
                for (int i = 0; i < num.length(); i++) {
                    int idx = num.charAt(i) - '0';
                    
                    if (now.next[idx] == null) {
                        now.next[idx] = new Node();
                    }
                    
                    now = now.next[idx];

                    // 1. 현재 번호를 넣는 중에 이미 끝난 번호(isEnd)를 만난 경우 (접두어가 존재함)
                    if (now.isEnd) {
                        isConsistent = false;
                        break;
                    }
                }
                
                // 2. 현재 번호 삽입을 마쳤는데, 이미 자식이 있는 경우 (내가 다른 번호의 접두어임)
                now.isEnd = true;
                for (int i = 0; i < 10; i++) {
                    if (now.next[i] != null) {
                        isConsistent = false;
                        break;
                    }
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}