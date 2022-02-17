package store.implementasi.unit.test.util;

import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputUtil(String info){
        System.out.print(info);
        String line = scanner.nextLine();
        return line;
    }
}