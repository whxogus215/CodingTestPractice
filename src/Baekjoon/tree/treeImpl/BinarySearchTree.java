package Backjoon.tree.treeImpl;

import java.util.Comparator;

public class BinarySearchTree<E> {

    private Node<E> root; // 루트 노드
    private int size; // 노드의 개수

    private final Comparator<? super E> comparator;

    public BinarySearchTree(){ // Comparable 사용
        this(null);
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
        // 이진 탐색 트리를 처음 생성하는 경우에는 null 및 노드가 개수가 0임
        this.root = null;
        this.size = 0;
    }

    /**
     * @param value 삽입하고자 하는 데이터
     * @return 정상적으로 삽입되었을 경우 true, 중복 원소를 삽입할 경우 false를 반환
     */
    public boolean add(E value){
        if (comparator == null) {
            return addUsingComparable(value) == null;
        }
        return addUsingComparator(value, comparator) == null;
    }

    private E addUsingComparable(E value){
        Node<E> current = root;

        if (current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        Node<E> currentParent;

        Comparable<? super E> compValue = (Comparable<? super E>) value;
        int compResult;

        do {
            currentParent = current;

            compResult = compValue.compareTo(current.value);

            if (compResult < 0) {
                current = current.left;
            } else if (compResult > 0) {
                current = current.right;
            } else {
                return value;
            }
        } while (current != null);

        Node<E> newNode = new Node<E>(value, currentParent);

        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }
        
        size++;

        return null; // 삽입이 정상적으로 되었으면 null 반환
    }

    private E addUsingComparator(E value, Comparator<? super E> comp) {

        Node<E> current = root;
        if (current == null) {
            root = new Node<E>(value, null);
            size++;
            return null;
        }

        Node<E> currentParent;
        int compResult;
        do {
            currentParent = current;
            compResult = comp.compare(value, current.value);
            if (compResult < 0) {
                current = current.left;
            } else if (compResult > 0) {
                current = current.right;
            } else {
                return value;
            }
        } while (current != null);

        Node<E> newNode = new Node<E>(value, currentParent);
        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }
        size++;
        return null;
    }


    /**
     * 
     * @param node 삭제되는 노드(= 대체되는 노드)
     * @return 대체할 노드
     */
    private Node<E> getSuccessorAndUnlink(Node<E> node) {
        Node<E> currentParent = node; // 삭제되는 노드
        Node<E> current = node.right; // 왼쪽 노드와 오른쪽 노드 중 오른쪽 노드로 선택함, 대체될 노드

        if (current.left == null) {
            currentParent.right = current.right;
            if (currentParent.right != null) { // 대체될 노드의 연결을 해제하고, 새로운 연결관계를 만듦
                currentParent.right.parent = currentParent;
            }
            current.right = null;
            return current;
         }

        while (current.left != null) {
            currentParent = current;
            current = current.left;
        }
        
        currentParent.left = current.right;
        if (currentParent.left != null) {
            currentParent.left.parent = currentParent; // 만약 null이면 null인 상태로 놔두면 됨
        }
        current.right = null; // 대체될 노드의 모든 링크 끊기
        return current;
    }

    /**
     * @param node 삭제 할 노드
     * @return 삭제 후 대체 되고 난 뒤의 해당 위치의 노드를 반환
     */
    private Node<E> deleteNode(Node<E> node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                if (node == root) {
                    root = null;
                }
                else {
                    node = null;
                }
                return null;
            }
        }

        if (node.left != null && node.right != null) {
            Node<E> replacement = getSuccessorAndUnlink(node); // 삭제할 노드를 대체할 노드
            
            node.value = replacement.value; // 노드 값 대체
        } else if (node.left != null) {
            if (node == root) {
                node = node.left;
                root = node;
                root.parent = null;
            } else {
                node = node.left;
            }
        } else {
            if (node == root) {
                node = node.right;
                root = node;
                root.parent = null;
            } else {
                node = node.right;
            }
        }

        return node;
    }
}
