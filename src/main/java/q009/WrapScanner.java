package q009;

import java.util.Scanner;

public class WrapScanner {
    private Scanner scanner;
    public WrapScanner() {
        scanner = new Scanner(System.in);
    }

    public String nextLine() {
        System.out.print("入力）");
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
