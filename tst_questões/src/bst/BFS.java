package bst;

import java.util.*;

class BFSdireita {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        BST5 bst = new BST5();
        for (String num : entrada) {
            bst.add(Integer.parseInt(num));
        }
        System.out.println(bst.bfs());
    }
}

class BST5 {
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

    public String bfs() {
        if (isEmpty()) return "";

        StringBuilder resultado = new StringBuilder();
        Queue<Node> fila = new LinkedList<>();
        fila.add(this.root);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size(); // controla os nós que serão removidos em cada nivel
            List<Integer> nivel = new ArrayList<>(); // é criada somente para o nível atual

            for (int i = 0; i < tamanhoNivel; i++){
                Node current = fila.poll();
                nivel.add(current.value);

                if (current.left != null) fila.add(current.left);
                if (current.right != null) fila.add(current.right);
            }

            for (int num : nivel){ // add o nivel da lista ao resultado e depois a lista(nivel é descartada)
                resultado.append(num).append(" ");
            }
        }
        return resultado.toString().trim();
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
