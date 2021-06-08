package day1;

/**
 * Find the two entries that sum to 2020;
 * what do you get if you multiply them together?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day1 {

    public static void main(String[] args) {
        Day1 d = new Day1();
        d.readFile();
        d.twoSum();
    }

    int target = 2020;
    List<Integer> expenseReport = new ArrayList<Integer>();

    void twoSum() {
        Search: for (int a : expenseReport) {
            for (int b : expenseReport) {
                if ((a + b) == target) {
                    System.out.println(a + ", " + b);
                    System.out.println(a * b);
                    break Search;
                }
            }
        }
    }

    void readFile() {
        try {
            //File myFile = new File("C:\\Users\\brian\\Desktop\\advent-of-code-2020\\day1\\input.txt");
            File myFile = new File("day1\\input.txt");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNextLine()) {
                expenseReport.add(fileScanner.nextInt());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void printFile() {
        for (int number : expenseReport) {
            System.out.print(number + " ");
        }
    }
}