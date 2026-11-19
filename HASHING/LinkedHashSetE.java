import java.util.LinkedHashSet;
   public class LinkedHashSetE {
    public static void main(String[] args) {

        // Create LinkedHashSet
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // Add elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);
        set.add(40);

        // Print set
        System.out.println("LinkedHashSet: " + set);

        // Check element
        System.out.println("Contains 20: " + set.contains(20));

        // Remove element
        set.remove(30);

        // Print after removal
        System.out.println("After Removal: " + set);

        // Size
        System.out.println("Size: " + set.size());

        // Iterate
        System.out.println("Elements:");

        for (int num : set) {
            System.out.println(num);
        }

        // Clear set
        set.clear();

        System.out.println("After Clear: " + set);
    }
}

