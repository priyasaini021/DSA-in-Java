 import java.util.Scanner;

public class CountSetBits {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.print("Enter a non-negative number: ");
    int n = sc.nextInt();

    if (n < 0) {
        System.out.println("Please enter a non-negative number");
    } else {
        int count = 0;

        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }

        System.out.println("Set bits: " + count);
    }

    sc.close();
}

}
