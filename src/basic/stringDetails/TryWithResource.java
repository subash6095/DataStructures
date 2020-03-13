package basic.stringDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) {
        usingOldTryCatch();
        usingTryWithResource();
    }

    public static void usingOldTryCatch() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("resources/test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void usingTryWithResource() {
        try (Scanner scanner = new Scanner(new File("resources/test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
