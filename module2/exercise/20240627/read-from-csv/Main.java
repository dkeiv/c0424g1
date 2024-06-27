import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String[]> buffer = new ArrayList<>();
        String filename = "data.txt";

        try {
            File myFile = new File(filename);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                buffer.add(line);
            }
            reader.close();

            for(String[] line : buffer) {
                String content = "Country [id= "
                        + line[0]
                        + ", code= " + line[1]
                        + " , name=" + line[2]
                        + "]";
                System.out.println(content);
            }

            System.out.println("exit...");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}