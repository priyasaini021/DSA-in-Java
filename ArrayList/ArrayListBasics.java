import java.util.ArrayList;
public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("ArrayList: " + list);

        // Get element
        System.out.println("Element at index 2: " + list.get(2));

        // Remove element
        list.remove(1);
        System.out.println("After removal: " + list);

        // Update element
        list.set(1, 100);
        System.out.println("After update: " + list);

        // Size
        System.out.println("Size: " + list.size());

        // Print all elements
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}

