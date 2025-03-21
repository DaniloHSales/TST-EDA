package bst;

import java.util.ArrayList;
import java.util.Scanner;

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
    public Node root;
    private int size;

    public boolean isEmpty(){return this.root == null;}

    public void add(int element){
        this.size += 1;
        if(isEmpty())
            this.root = new Node(element);
        else{
            Node aux = this.root;
            while(aux != null){
                if(element < aux.value){
                    if(aux.left == null){
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if(aux.right == null){
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
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