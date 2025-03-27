package bst;

import java.util.*;

public class SomaFolhas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] elementos = sc.nextLine().split(" ");

        BSTeta teta = new BSTeta();
        for (String num : elementos) {
            teta.add(Integer.parseInt(num));
        }

        System.out.println(teta.contaFolhas());
    }
}

class BSTeta {

    Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        if (isEmpty()) {
            this.root = new Node(element); 
        }else {
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

    public int  contaFolhas(){
        return contaFolhas(this.root);
    }

    private int contaFolhas(Node node){
       if (node == null) return 0;

       while (node.left == null && node.right == null){
            return node.value;
       } 

       return contaFolhas(node.left) + contaFolhas(node.right);
    }
    
}

class Node {
    Node left;
    Node right;
    Node parent;
    int value;

    public Node(int value) {
        this.value = value;
    }
}
