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

}
