import java.util.TreeMap;

public class TreeMap {
    public static void main(String[] args) {

        // Create TreeMap
        TreeMap<Integer, String> map = new TreeMap<>();

        // Insert elements
        map.put(4, "Apple");
        map.put(2, "Banana");
        map.put(5, "Mango");
        map.put(1, "Orange");
        map.put(3, "Grapes");

        // Print TreeMap
        System.out.println("TreeMap: " + map);

        // Get value
        System.out.println("Value at key 2: " + map.get(2));

        // First and last key
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());

        // Lower and higher key
        System.out.println("Lower Key than 3: " + map.lowerKey(3));
        System.out.println("Higher Key than 3: " + map.higherKey(3));

        // Remove element
        map.remove(4);

        // Iterate TreeMap
        System.out.println("After Removing Key 4:");

        for (Integer key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }

        // Size
        System.out.println("Size: " + map.size());
    }
}

