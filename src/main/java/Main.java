import SegmentDisplay.FullDisplayer;
import SegmentDisplay.SegmentDisplayer;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FullDisplayer displayer = new FullDisplayer();
        String answer = "";
        do {
            System.out.println("Enter a number to display (Q to exit): ");
            answer = scanner.nextLine();
            if (answer.equals("Q") || answer.equals("q"))
                break;
            displayer.showNumber(answer);
        }while(true);
    }
}
