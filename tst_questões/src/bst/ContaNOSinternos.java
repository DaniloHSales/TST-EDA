package bst;

import java.util.*;

public class ContaNOSinternos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        BST1 bst = new BST1();
        for (String num : entrada) {
            bst.add(Integer.parseInt(num));
        }

        System.out.println(bst.contaNos());
    }
}

class BST1 {
    Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        if (isEmpty()) {
            this.root = new Node(element);
        } else {
            Node aux = this.root;
            while (aux != null) {
                if (element < aux.value) {
                    if (aux.left == null) {
                        aux.left = new Node(element);
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        aux.right = new Node(element);
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public int contaNos() {
        return contaNos(this.root);
    }

    private int contaNos(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0; // Nó nulo ou folha, não conta
        }
        return 1 + contaNos(node.left) + contaNos(node.right);
    }
}

class Node{
    Node left;
    Node right;
    Node parent;
    int value;

    public Node(int value){
        this.value = value;
    }
}
