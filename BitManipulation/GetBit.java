import java.util.Scanner;

public class GetBit {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int n = sc.nextInt();

    System.out.print("Enter bit position: ");
    int i = sc.nextInt();

    int bitMask = 1 << i;

    if ((n & bitMask) == 0) {
        System.out.println("Bit is 0");
    } else {
        System.out.println("Bit is 1");
    }

    sc.close();
}

}
