import java.util.*;

class Solution {
    
    static class Node {
        int number;
        int x;
        int y;
        Node left, right;
        
        public Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return String.valueOf(this.number);
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            int number = i + 1;
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            nodes.add(new Node(number, x, y));
        }
        Collections.sort(nodes, (n1, n2) -> {
            if (n1.y == n2.y) {
                return n1.x - n2.x;
            }
            return n2.y - n1.y;
        });
        
        // System.out.println(Arrays.toString(nodes.toArray(new Node[0])));
        
        Node root = nodes.get(0);
        for(int i = 1; i < nodes.size(); i++) {
            Node parent = root;
            Node child = nodes.get(i);
            while(true) {
                if (child.x < parent.x) {
                    if (parent.left == null) {
                        parent.left = child;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = child;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrder(root, new ArrayList<Integer>());
        answer[1] = postOrder(root, new ArrayList<Integer>());
        
        return answer;
    }
    
    public static int[] preOrder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.number);
            preOrder(node.left, result);
            preOrder(node.right, result);    
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int[] postOrder(Node node, List<Integer> result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.number);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 트리를 구성하고, 전위/후위 순회 결과를 출력할 것!
// nodeinfo 데이터와 트리를 구성하는 규칙에 따라 트리를 구성하는 것이 관건!
/**
1. 루트 노드는 y 값이 가장 크다.
2. 루트 노드를 기준으로 x 값이 작은 쪽은 왼쪽, x 값이 큰 쪽은 오른쪽 서브트리다.

우선순위 큐 비교 기준
1. y값이 큰 순으로
2. y값이 같다면, x 값이 작은 순으로

우선순위 큐에서 하나씩 꺼내서 이진트리(배열)에 저장 => 전위/후위 순회하기
**/