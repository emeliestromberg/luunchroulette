// Funkar inte??

// Java Program to illustrate
// reading from Text File
// using Scanner Class
import java.io.File;
import java.util.Scanner;

public class GFG3 {

    public static void main(String[] args) throws Exception {
        // pass the path to the file as a parameter
        File file = new File("/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/TextLunchRouletteTest.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}
