package com.TreePackage;

public class MyTree {
    public static void main(String[] args) {
        //główna gałąź
        Node<String> root = new Node<>(null, "Menu główne");

        //pierwsze submeny
        Node<String> ch1 = root.addChild("1");
        Node<String> ch2 = root.addChild("2");
        Node<String> ch3 = root.addChild("3");

        //kolejne submenu i niższe
        Node<String> ch1_1 = ch1.addChild("1_1");
        Node<String> ch1_2 = ch1.addChild("1_2");
        Node<String> ch1_3 = ch1.addChild("1_3");

        Node<String> ch1_1_1 = ch1_1.addChild("1_1_1");
        Node<String> ch1_1_2 = ch1_1.addChild("1_1_2");
        Node<String> ch1_1_3 = ch1_1.addChild("1_1_3");

        Node<String> ch1_2_1 = ch1_2.addChild("1_2_1");
        Node<String> ch1_2_2 = ch1_2.addChild("1_2_2");

        Node<String> ch1_3_1 = ch1_3.addChild("1_3_1");

        Node<String> ch2_1 = ch2.addChild("2_1");
        Node<String> ch2_2 = ch2.addChild("2_2");

        Node<String> ch3_1 = ch3.addChild("3_1");

        //tworzę drzewo
        Tree<String> drzewo = new Tree<>(root);

        //pokaż całą stworzoną hierarchię (dla sprawdzenia)
        System.out.println(drzewo);

        // pokaż główny komunikat (korzeń i dostępne podmenu, korzeń leży już na stosie)
        drzewo.printCurrentLevel(root);

        System.out.println();
        System.out.println("START");
        System.out.println();

        // wybieramy którąś opcję z podmenu i odkładamy na stos wybrane
        drzewo.goDown(ch1);
        System.out.println("Wybrano opcje 1");

        //pokazuje jakie opcje podmenu dostępne są dla odłożonego na stos elemntu

        drzewo.printCurrentLevel(drzewo.menuStack.peek());
        System.out.println();

        //jeszcze niżej
        drzewo.goDown(ch1_1);
        System.out.println("Wybrano opcje 1_1");
        drzewo.printCurrentLevel(drzewo.menuStack.peek());
        System.out.println();

        //wracamy
        drzewo.goUp();
        System.out.println("powrót poziom wyżej");
        drzewo.printCurrentLevel(drzewo.menuStack.peek());
        System.out.println();

        drzewo.goDown(ch1_3_1);
        drzewo.printCurrentLevel(drzewo.menuStack.peek());
    }
}
