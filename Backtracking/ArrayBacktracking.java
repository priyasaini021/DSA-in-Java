public class ArrayBacktracking {
    public static void changeArray(int[] arr, int index, int value) {
        // Base case
        if (index == arr.length) {
            printArray(arr);
            return;
        }

        // Choose
        arr[index] = value;

        // Explore
        changeArray(arr, index + 1, value + 1);

        // Backtrack
        arr[index] = arr[index] - 2;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[5];

        changeArray(arr, 0, 1);

        System.out.println("After backtracking:");
        printArray(arr);
    }
}

