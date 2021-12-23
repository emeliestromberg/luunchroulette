import java.io.*;

public class fileReader {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/TextLunchRouletteTest.txt"));
            String s;

            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }
    }
}
