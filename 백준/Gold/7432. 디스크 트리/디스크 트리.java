import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N이 주어지지 않고 바로 문자열이 들어오는 경우 등 예외처리가 필요할 수도 있으나,
        // 문제 조건상 N이 주어지므로 nextInt() 사용
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        
        Node root = new Node(""); // 루트 노드

        while(N-- > 0) {
            Node now = root;
            String line = sc.next();
            // 1. 역슬래시 파싱 수정
            String[] directory = line.split("\\\\"); 
            
            for(String d : directory) {
                // 2. 자식 노드 확인 및 이동 로직 수정 (Map 사용)
                if (!now.children.containsKey(d)) {
                    now.children.put(d, new Node(d));
                }
                now = now.children.get(d);
            }
        }

        dfs(root, 0);
    }

    private static void dfs(Node current, int depth) {
        // TreeMap은 Key 기준 오름차순 정렬이 되어 있으므로 별도 정렬 불필요
        for(String key : current.children.keySet()) {
            Node nextNode = current.children.get(key);
            
            // 공백 출력 (depth만큼)
            for(int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            
            System.out.println(key);
            dfs(nextNode, depth + 1);
        }
    }
}

class Node {
    String name;
    // TreeMap을 사용하여 이름을 기준으로 자동 정렬되게 함
    Map<String, Node> children = new TreeMap<>();

    public Node(String name) {
        this.name = name;
    }
}
