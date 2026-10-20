 import java.util.Scanner;
 public class squarematrix {
  public static boolean isSquareMatrix(int rows, int cols) {
    return rows == cols;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter rows: ");
    int rows = sc.nextInt();

    System.out.print("Enter columns: ");
    int cols = sc.nextInt();

    if (isSquareMatrix(rows, cols)) {
        System.out.println("Square Matrix");
    } else {
        System.out.println("Not a Square Matrix");
    }

    sc.close();
}

}

