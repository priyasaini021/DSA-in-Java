import java.util.LinkedHashMap;
public class LinkedHashmap {

    public static void main(String[] args) {
        // Create LinkedHashMap
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // Insert elements
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);
        map.put("Orange", 40);

        // Print LinkedHashMap
        System.out.println("LinkedHashMap: " + map);

        // Get value
        System.out.println("Value of Apple: " + map.get("Apple"));

        // Check key
        System.out.println("Contains Banana: " + map.containsKey("Banana"));

        // Update value
        map.put("Apple", 50);

        // Remove element
        map.remove("Orange");

        // Iterate LinkedHashMap
        System.out.println("After Operations:");

        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }

        // Size
        System.out.println("Size: " + map.size());
    }
}
