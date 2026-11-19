 import java.util.HashSet;

public class CountDistinctElements {

    public static int countDistinct(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        // Add elements into HashSet
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // Return distinct count
        return set.size();
    }

    public static void main(String[] args) {

        int arr[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};

        int ans = countDistinct(arr);

        System.out.println("Distinct Elements Count: " + ans);
    }
}

