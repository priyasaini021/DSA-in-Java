 import java.util.Scanner;

public class StringCompression {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String str = sc.nextLine();

    StringBuilder compressed = new StringBuilder();

    for (int i = 0; i < str.length();) {
        char ch = str.charAt(i);
        int count = 0;

        while (i < str.length() && str.charAt(i) == ch) {
            count++;
            i++;
        }

        compressed.append(ch);
        compressed.append(count);
    }

    System.out.println("Compressed string: " + compressed);

    sc.close();
}

}

