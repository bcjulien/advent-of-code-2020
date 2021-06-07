/**
 * Find the two entries that sum to 2020;
 * what do you get if you multiply them together?
 */

package java.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day1 {
    void readFile() {
        try {
            File myFile = new File("input.txt");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNextLine()) {
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}