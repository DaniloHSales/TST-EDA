package bst;

import java.util.*;

class Predecessor_bst {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");
        int predecessor = sc.nextInt();

        BST bst = new BST();
        for(int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.predecessorPath(predecessor).toString());
    }
}

class BST{
    Node root;

    public boolean isEmpty(){
        return this.root == null;
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

                if (current.right != null) fila.add(current.right);
                if (current.left != null) fila.add(current.left);
            }

            for (int num : nivel){ // add o nivel da lista ao resultado e depois a lista(nivel é descartada)
                resultado.append(num).append(" ");
            }
        }
        return resultado.toString().trim();
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

    public ArrayList<Integer> predecessorPath(int element){
        // tree = [10, 8, 1, 9, 18, 20, 25] predecessor de 10 = [9]
        ArrayList<Integer> path = new ArrayList<>();
        // acha primeiro o 10
        Node node = search(element);
        // coloca o 10 na lista
        path.add(node.value);
        // verifica se o 10 tem um filho a esquerda
        if(node.left != null){
            // anda para a esquerda = 8
            node = node.left; // node == 8
            // coloca o 8 na lista = [10, 8]
            path.add(node.value);
            // vai para a direita até o 9
            while(node.right != null){
                // anda para a direita = 9
                node = node.right;
                // coloca o 9 na lista = [10, 8, 9]
                path.add(node.value);
            }
        } else {
            // parent == 20
            Node parent = node.parent; // node == 25
            while (parent != null && parent.value > node.value) { // 20 > 25 falso
                path.add(parent.value);
                parent = parent.parent;
            }
            if (parent != null)
                // coloca 20 na lista
                path.add(parent.value); // lista = [25, 20]
        }
        return path;
    }

    private Node search(int element){
        Node aux = this.root;
        while(aux != null){
            if(element == aux.value) return aux;
            if(element < aux.value) aux = aux.left;
            if(element > aux.value) aux = aux.right;
        }
        return null;
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