package com.infoshareacademy;

import com.infoshareacademy.MenuTree.MenuHierarchyBuilder;
import com.infoshareacademy.MenuTree.Node;
import com.infoshareacademy.MenuTree.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class App {

private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        Node<String> root = new MenuHierarchyBuilder().build();
        Tree<String> menu = new Tree<>(root);

        menu.printCurrentLevel(root);
        new Scanner(System.in).nextInt();

        stdout.info("Hello World!");
    }
}