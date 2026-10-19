public class linearSearch {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] numbers = {10, 25, 30, 45, 50};
        int key = 30;

        int index = linearSearch(numbers, key);

        if (index != -1) {
            System.out.println("key found at index : " + index);
        } else {
            System.out.println("key not found");
        }
    }
}

