package Testing;

import java.io.* ;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
public class MongoCsvImport {
    public static void main(String[] args) throws Exception {
      /*System.out.print("start");
    Scanner sc = new Scanner(new File("Marketing.csv"));
    //parsing a CSV file into the constructor of Scanner class
    sc.useDelimiter("\n");
    //setting comma as delimiter pattern
    while (sc.hasNext()) {
        System.out.print("in loop");
      System.out.print(sc.next());
    }
    sc.close();
    System.out.print("end programme");
    //closes the scanner*/
        try {
            File myObj = new File("C:\\Users\\PC\\IdeaProjects\\JAVA_JEE\\untitled\\src\\Testing\\Marketing.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

