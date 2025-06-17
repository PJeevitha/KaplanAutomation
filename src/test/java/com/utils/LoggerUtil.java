package com.utils;

public class LoggerUtil {
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void green(String message) {
        System.out.println(GREEN + message + RESET);
    }

    public static void yellow(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    public static void red(String message) {
        System.out.println(RED + message + RESET);
    }
}
