package com.infoshareacademy.MenuTree;

import java.util.Stack;

public class Tree<T> {

    Stack<Node<T>> menuStack = new Stack<>();

    public Stack<Node<T>> getMenuStack() {
        return menuStack;
    }

    private Node<T> root;
    StringBuilder output = new StringBuilder();

    public Tree() {
        root = null;
    }

    public Tree(Node<T> root) {
        this.root = root;
        menuStack.push(root);
    }

    public int getLevel(Node<T> node) {
        if (node == root) {
            return 0;
        }
        return 1 + getLevel(node.getParent());
    }

    void makeTreeStringOutline(Node<T> n) {
        for (int i = 0; i < getLevel(n); i++) {
            output.append("\t");
        }
        output.append(n + "\n");
        Node<T> temp = n.getLeftMostChild();
        while (temp != null) {
            makeTreeStringOutline(temp);
            temp = temp.getRightSibling();
        }
    }

/*
    void makeSubmenu(Node<T> n) {
        for (int i = 0; i < getLevel(n); i++) {
            output.append("\t");
        }
        output.append(n + "\n");
        Node<T> temp = n.getLeftMostChild();
        while (temp != null) {
            makeTreeStringOutline(temp);
            temp = temp.getRightSibling();
        }
    }
*/

    public String toString() {
        output = new StringBuilder();
        output.append("\nHierarchia stworzonego drzewa\n");
        output.append("-----------------------------\n");
        makeTreeStringOutline(root);
        output.append("-----------------------------\n");
        return output.toString();
    }

    public String printCurrentLevel(Node<T> n) {
        output = new StringBuilder();
        System.out.println(n + " | Level: " + this.getLevel(n)+"\n");
        Node<T> temp = n.getLeftMostChild();
        while (temp != null) {
            System.out.println(temp + " | Level: " + getLevel(temp));
            temp = temp.getRightSibling();
        }
        return output.toString();
    }

    public void goDeeper(Node<T> n) {
        menuStack.push(n);
    }

    public Node<T> goBack() {
        menuStack.pop();
        return menuStack.peek();
    }

    public void goToRoot() {
        menuStack.empty();
        menuStack.push(root);
    }

}