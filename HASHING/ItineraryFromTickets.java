 import java.util.HashMap;
import java.util.HashSet;

public class ItineraryFromTickets {

    public static void findItinerary(HashMap<String, String> tickets) {

        HashSet<String> destinations = new HashSet<>();

        // Store all destination cities
        for (String destination : tickets.values()) {
            destinations.add(destination);
        }

        String start = null;

        // Find starting city
        for (String source : tickets.keySet()) {

            if (!destinations.contains(source)) {
                start = source;
                break;
            }
        }

        // Check starting city
        if (start == null) {
            System.out.println("No valid starting city found");
            return;
        }

        System.out.print("Itinerary: ");

        // Print complete itinerary
        String current = start;

        while (tickets.containsKey(current)) {

            System.out.print(current + " -> ");

            current = tickets.get(current);
        }

        System.out.println(current);
    }

    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        findItinerary(tickets);
    }
}

