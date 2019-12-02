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

        //pokaż całą hierarchię w drzewie
        stdout.info(menu.toString() + "\n"); // TODO: 02.12.2019 do usunięcia po zaimplementowaniu całości

        menu.printCurrentLevel(root);
        stdout.info("\n");
        stdout.info("Pokaż stos: \n");
        menu.goDeeper(root.getChild(0));

        menu.goBack();
        for (Node node : menu.getMenuStack()) {
            System.out.println(node);
        }



        stdout.info("Rozmiar stosu: " + String.valueOf(menu.getMenuStack().size()));
        stdout.info("\n\nWybierz opcję.");
        new Scanner(System.in).nextInt();

    }
}