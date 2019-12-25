package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BreadcrumbsPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static void printBreadcrumbs() {
        Menu.BREADCRUMBSTACK.forEach(menuItem -> stdout.info(" > " + menuItem));
    }
}