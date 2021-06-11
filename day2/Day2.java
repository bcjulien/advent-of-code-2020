package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * How many passwords are valid according to the password policy?
 * 1-3 a: abcde means password must have 1-3 a's.
 */

public class Day2 {
    int validCounter = 0;
    List<String> passwords = new ArrayList<String>();

    public static void main(String[] args) {
        Day2 d = new Day2();
        d.readFile();
        d.readPasswords();
    }

    void readFile() {
        try {
            File myFile = new File("day2\\input.txt");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNextLine()) {
                passwords.add(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error has occured.");
            ex.printStackTrace();
        }
    }

    /**
     * I was splitting each section by the '-' and ':'. It might be easier to
     * split by the spaces and just remove those chars after.
     * 
     * No! I can use multiple delimiters!
     */
    void testSplitFile() {
        String[] temp = passwords.get(0).split("\\ |-|:");
        int min = Integer.parseInt(temp[0]);
        int max = Integer.parseInt(temp[1]);
        char target = temp[2].charAt(0);
        String password = temp[4];

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Character: " + target);
        System.out.println("Password: " + password);

        int targetCounter = 0;
        for (int x = 0; x < password.length(); x++) {
            if (password.charAt(x) == target) {
                targetCounter++;
            }
        }
        System.out.println("Number of " + target + "'s in string: " + targetCounter);
        if (targetCounter < min || targetCounter > max) {
            System.out.println("This password is not valid.");
        }
    }

    void readPasswords() {
        for (String target : passwords) {
            int min = 0;
            int max = 0;
            char ch = '@';
            String password = "";
            int targetCharCounter = 0;

            String[] temp = target.split("\\ |-|:");
            min = Integer.parseInt(temp[0]);
            max = Integer.parseInt(temp[1]);
            ch = temp[2].charAt(0);
            password = temp[4];

            for (int x = 0; x < password.length(); x++) {
                if (password.charAt(x) == ch) {
                    targetCharCounter++;
                }
            }

            // System.out.println("\nMin: " + min);
            // System.out.println("Max: " + max);
            // System.out.println("Character: " + ch);
            // System.out.println("Password: " + password);
            // System.out.println("Number of " + ch + "'s in string: " + targetCharCounter);

            if (targetCharCounter >= min && targetCharCounter <= max) {
                validCounter++;
                // System.out.println("VALID");
            }
        }
        System.out.print("\nValid: " + validCounter);
    }

    void printFile() {
        for (String target : passwords) {
            System.out.println(target);
        }
    }
}
