package com.company;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Set<String> quotesSet = new HashSet<>();
        GetURLcontent getURLcontent = new GetURLcontent();
        String result = getURLcontent.run("https://api.kanye.rest/text");
        quotesSet.add(result);
        while (true) {
            System.out.println("Please type:");
            System.out.println("next - random Kanye West quotes");
            System.out.println("exit - exit app");
            final String next = scanner.next();
            if (next.equals("next")) {
                System.out.println("Random Kanye West quotes:");
                System.out.println(result);
                System.out.println("_____________");
                while (quotesSet.contains(result)) {
                    result = getURLcontent.run("https://api.kanye.rest/text");
                }
                quotesSet.add(result);
            }
            if (next.equals("exit")) {
                break;
            }
        }
    }
}
