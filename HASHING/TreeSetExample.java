 import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        // Create TreeSet
        TreeSet<Integer> set = new TreeSet<>();

        // Add elements
        set.add(50);
        set.add(20);
        set.add(40);
        set.add(10);
        set.add(30);
        set.add(20);

        // Print sorted elements
        System.out.println("TreeSet: " + set);

        // First and Last
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());

        // Lower and Higher
        System.out.println("Lower than 30: " + set.lower(30));
        System.out.println("Higher than 30: " + set.higher(30));

        // Remove element
        set.remove(20);

        System.out.println("After Removal: " + set);

        // Descending order
        System.out.println("Descending: " + set.descendingSet());

        // Size
        System.out.println("Size: " + set.size());
    }
}
