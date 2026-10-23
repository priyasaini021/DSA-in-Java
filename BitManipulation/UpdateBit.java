 import java.util.Scanner;

public class UpdateBit {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int n = sc.nextInt();

    System.out.print("Enter bit position: ");
    int i = sc.nextInt();

    System.out.print("Enter new bit (0 or 1): ");
    int newBit = sc.nextInt();

    if (i < 0 || i > 31 || (newBit != 0 && newBit != 1)) {
        System.out.println("Invalid input");
    } else {
        int bitMask = 1 << i;

        if (newBit == 1) {
            n = n | bitMask;
        } else {
            n = n & (~bitMask);
        }

        System.out.println("Updated number: " + n);
    }

    sc.close();
}

}

