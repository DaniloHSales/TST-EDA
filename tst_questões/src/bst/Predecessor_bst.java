package bst;

import java.util.*;

class Predecessor_bst {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");
        int predecessor = sc.nextInt();

        BST2 bst = new BST2();
        for(int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.predecessorPath(predecessor).toString());
    }
}

class BST2{
    Node root;

    public boolean isEmpty(){
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

    public ArrayList<Integer> predecessorPath(int element){
        ArrayList<Integer> path = new ArrayList<>(); // tree = [10, 8, 1, 9, 18, 20, 25] predecessor de 10 = [9]
        Node node = search(element); // acha primeiro o 10
        path.add(node.value); // coloca o 10 na lista  

        if(node.left != null){ // verifica se o 10 tem um filho a esquerda           
            node = node.left; // anda para a esquerda = 8           
            path.add(node.value); // coloca o 8 na lista = [10, 8]
            while(node.right != null){              
                node = node.right; // anda para a direita = 9
                path.add(node.value); // coloca o 9 na lista = [10, 8, 9]
            }
        } else {
            Node parent = node.parent;
            while (parent != null && parent.value > node.value) {
                path.add(parent.value);
                parent = parent.parent;
            }
            if (parent != null)
                path.add(parent.value);
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