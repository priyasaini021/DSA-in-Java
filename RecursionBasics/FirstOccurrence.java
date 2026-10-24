  public class FirstOccurrence {
    public static int firstOccurrence(
            int[] arr, int index, int key) {

        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == key) {
            return index;
        }

        return firstOccurrence(arr, index + 1, key);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 2, 9};

        System.out.println(firstOccurrence(arr, 0, 2));
    }
}
