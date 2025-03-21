package bst;

import java.util.*;

public class SomaFolhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] elementos = sc.nextLine().split(" ");

        BST bst = new BST();
        for (int i = 0; i < elementos.length; i++){
            bst.add(Integer.parseInt(elementos[i]));
        }
        System.out.println(bst.somaFolhas());
    }
}

class BST{
    private Node root;
    private int size;

    public boolean isEmpty(){
        return this.root == null;
    }

    public Node getRoot() { // Método para acessar a raiz
        return this.root;
    }

    public void add(int element){
        if (isEmpty()) this.root = new Node(element);
        else {
            Node aux = this.root;
            while(aux != null)
                if (element < aux.value){
                    if (aux.left == null){
                        Node node = new Node(element);
                        aux.left = node;
                        node.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }else{
                    if(aux.right == null){
                        Node node = new Node(element);
                        aux.left = node;
                        node.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    

        public int somaFolhas(){
            return somaFolhas(this.root);
        }

        private int somaFolhas(Node node) {
            if (this.root == null) return 0;
            else if (node.left == null && node.right == null) return node.value;
            // soma folhas dos filhos esquerdo e direito
            return somaFolhas(node.left) + somaFolhas(node.right);
        }
}

class Node{

    Node left;
    Node right;
    Node parent;

    int value;

    public Node(int value){
        this.value= value;
    }
}    




