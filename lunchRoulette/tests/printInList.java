import java.util.*;
import java.io.*;

public class printInList {
    public static void main(String[] args) throws IOException {
        String[] anArray = { "A", "B", "C", "D", "E" };
        List<String> aList = new ArrayList();
        for (int i = 0; i < anArray.length; i++) {
            aList.add(anArray[i]);
        }
        File file = new File("/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/textFileTest.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter("/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/textFileTest.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < aList.size(); i++) {
            bw.write(aList.get(i));
        }
        bw.close();
    }
}