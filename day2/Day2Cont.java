package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Each policy describes two positions in the password,
 * 1 means first character. Exactly one position must have
 * the letter.
 */

public class Day2Cont {
    int validCounter = 0;
    List<String> passwords = new ArrayList<String>();

    public static void main(String[] args) {
        Day2Cont d = new Day2Cont();
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

    void readPasswords() {
        for (String target : passwords) {
            int first = 0;
            int last = 0;
            char ch = '@';
            String pwd = "";
            boolean alreadyUsed = false;
            boolean valid = true;

            String[] temp = target.split("\\ |-|:");
            first = Integer.parseInt(temp[0]);
            last = Integer.parseInt(temp[1]);
            ch = temp[2].charAt(0);
            pwd = temp[4];

            do {
                if (pwd.charAt(first-1) == ch && pwd.charAt(last-1) == ch) {
                    valid = false;
                }
                else if (pwd.charAt(first-1) != ch && pwd.charAt(last-1) != ch) {
                    valid = false;
                }
                else if (pwd.charAt(first-1) == ch && pwd.charAt(last-1) != ch) {
                    validCounter++;
                    break;
                }
                else if (pwd.charAt(first-1) != ch && pwd.charAt(last-1) == ch) {
                    validCounter++;
                    break;
                }

            } while (valid);
        }
        System.out.println("VALID: " + validCounter);
    }

}
