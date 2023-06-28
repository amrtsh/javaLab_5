package ua.lviv.iot.algo.part1.lab5.readers;
import java.util.Scanner;

public class Reader {
    public String readFromConsole() {
        System.out.println("Enter your text:\n");
        return new Scanner(System.in).nextLine();
    }
}
