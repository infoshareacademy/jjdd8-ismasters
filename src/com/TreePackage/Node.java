package com.TreePackage;

import java.util.LinkedList;

class Node<T> {
    private T data;
    private Node<T> parent;
    private LinkedList<Node<T>> children;

    public Node() {
        //tworzymy węzeł, nie ma dzieci, nie ma rodzica, węzeł root i liść jednocześnie
        parent = null;
        children = new LinkedList<>();
    }

    public Node(Node<T> parent) {
        //tworzymy węzeł, nie ma dzieci, ma rodzica
        this();
        this.parent = parent;
    }

    public Node(Node<T> parent, T data) {
        this(parent);
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public Node<T> addChild(T data) {
        Node<T> child = new Node<>(this, data);
        children.add(child);
        return child;
    }

    public Node<T> getChild(int i) {
        return children.get(i);
    }

    public Node<T> removeChild(int i) {
        return children.remove(i);
    }

    public void removeChildren() {
        children.clear();
    }

    public LinkedList<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getLeftMostChild() {
        if (!children.isEmpty()) {
            return children.get(0);
        }
        return null;
    }

    public Node<T> getRightSibling() {
        if (parent != null) {
            LinkedList<Node<T>> parentsChildren = parent.getChildren();
            int myPosition = parentsChildren.indexOf(this);
            if (myPosition < parentsChildren.size() - 1) {
                return parentsChildren.get(myPosition + 1);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

