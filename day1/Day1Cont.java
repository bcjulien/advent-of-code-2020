package day1;

/**
 * Find 3 numbers that sum to 2020.
 * Find the product of these 3 numbers.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Cont {

    int target = 2020;
    List<Integer> expenseReport = new ArrayList<Integer>();

    public static void main(String[] args) {
        Day1Cont d = new Day1Cont();
        d.readFile();
        d.threeSum();
    }

    // can I do list slices in Java? In python I did expenseReport[itr:]
    void threeSum() {
        Search: for (int a : expenseReport) {
            for (int b : expenseReport) {
                for (int c : expenseReport) {
                    if (a + b + c == target) {
                        System.out.println(a + ", " + b + ", " + c);
                        System.out.println(a * b * c);
                        break Search;
                    }
                }
            }
        }
    }

    void readFile() {
        try {
            File myFile = new File("day1\\input.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                expenseReport.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error has occured.");
            ex.printStackTrace();
        }
    }
}
