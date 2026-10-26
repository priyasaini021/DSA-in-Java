public class BinaryStrings {
    public static void generate(
            int n, int lastPlace, String result) {

        // Base case
        if (n == 0) {
            System.out.println(result);
            return;
        }

        
        generate(n - 1, 0, result + "0");

        if (lastPlace == 0) {
            generate(n - 1, 1, result + "1");
        }
    }

    public static void main(String[] args) {
        generate(3, 0, "");
    }
}

