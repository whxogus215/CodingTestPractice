package Backjoon.tree.treeImpl;

class Node<E> {

    E value;

    Node<E> left;
    Node<E> right;
    Node<E> parent;

    Node(E value, Node<E> parent) { // 부모노드와 연결되는 경우
        this.value = value;
        this.parent = parent;
        this.right = null;
        this.left = null;
    }

    Node(E value){
        this(value, null);
    }
}
