package com.infoshareacademy.MenuTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuHierarchyBuilder {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public Node<String> build() {
        //główna gałąź
        Node<String> root = new Node<>(null, "Menu główne");

        //pierwsze submenu
        Node<String> ch1 = root.addChild("1. Pokaż wszystkie eventy");
        Node<String> ch2 = root.addChild("2. Wyświetl wydarzenia wg organizatora");
        Node<String> ch3 = root.addChild("3. Wyświetl wydarzenia wg daty");
        Node<String> ch4 = root.addChild("4. Menu testujące zagnieżdzenia");

/*
        //kolejne submenu i niższe
        Node<String> ch1_1 = ch1.addChild("");
        Node<String> ch1_2 = ch1.addChild("1_2");
        Node<String> ch1_3 = ch1.addChild("1_3");

        Node<String> ch1_1_1 = ch1_1.addChild("1_1_1");
        Node<String> ch1_1_2 = ch1_1.addChild("1_1_2");
        Node<String> ch1_1_3 = ch1_1.addChild("1_1_3");

        Node<String> ch1_2_1 = ch1_2.addChild("1_2_1");
        Node<String> ch1_2_2 = ch1_2.addChild("1_2_2");


        Node<String> ch1_3_1 = ch1_3.addChild("1_3_1");
*/
        Node<String> ch2_1 = ch2.addChild("Wybierz organizatora");
        Node<String> ch2_2 = ch2.addChild("Wróć");

        Node<String> ch3_1 = ch3.addChild("Wybierz datę");
        Node<String> ch3_2 = ch3.addChild("Wróć");

        Node<String> ch4_1 = ch4.addChild("Submenu opcji 4");
        Node<String> ch4_2 = ch4.addChild("Wróć poziom wyżej");

        Node<String> ch4_1_1 = ch4_1.addChild("Submenu 1 w submenu dla opcji 4");
        Node<String> ch4_1_2 = ch4_1.addChild("Wróć poziom wyżej");
        Node<String> ch4_1_3 = ch4_1.addChild("Wróć do głównego menu");


//        //tworzę drzewo
//        Tree<String> drzewo = new Tree<>(root);
//
//        //pokaż całą stworzoną hierarchię (dla sprawdzenia)
//        System.out.println(drzewo);
//
//        // pokaż główny komunikat (korzeń i dostępne podmenu, korzeń leży już na stosie)
//        drzewo.printCurrentLevel(root);
//
//        System.out.println();
//        System.out.println("START");
//        System.out.println();
//
//        // wybieramy którąś opcję z podmenu i odkładamy na stos wybrane
//        drzewo.goDown(ch1);
//        System.out.println("Wybrano opcje 1");
//
//        //pokazuje jakie opcje podmenu dostępne są dla odłożonego na stos elemntu
//
//        drzewo.printCurrentLevel(drzewo.menuStack.peek());
//        System.out.println();
//
//        //jeszcze niżej
//        drzewo.goDown(ch1_1);
//        System.out.println("Wybrano opcje 1_1");
//        drzewo.printCurrentLevel(drzewo.menuStack.peek());
//        System.out.println();
//
//        //wracamy
//        drzewo.goUp();
//        System.out.println("powrót poziom wyżej");
//        drzewo.printCurrentLevel(drzewo.menuStack.peek());
//        System.out.println();
//
//        drzewo.goDown(ch1_3_1);
//        drzewo.printCurrentLevel(drzewo.menuStack.peek());
        return root;
    }
}
