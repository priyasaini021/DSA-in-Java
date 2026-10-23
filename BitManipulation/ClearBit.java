 import java.util.Scanner;

public class ClearBit {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int n = sc.nextInt();

    System.out.print("Enter bit position: ");
    int i = sc.nextInt();

    int bitMask = ~(1 << i);
    int result = n & bitMask;

    System.out.println("Result: " + result);

    sc.close();
}

}
