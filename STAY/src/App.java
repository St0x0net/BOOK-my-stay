import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 * Stores centralized availability of rooms
 */

class App{

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

/**
 * ============================================================
 * CLASS - Room
 * ============================================================
 * Domain model representing room details
 */

class Room {

    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

/**
 * ============================================================
 * CLASS - RoomSearchService
 * ============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Provides read-only search functionality
 * for guests to view available rooms.
 */

class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        // Single Room
        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            System.out.println("Beds: " + singleRoom.getBeds());
            System.out.println("Size: " + singleRoom.getSize() + " sqft");
            System.out.println("Price per night: " + singleRoom.getPrice());
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        // Double Room
        if (availability.get("Double") > 0) {
            System.out.println("Double Room:");
            System.out.println("Beds: " + doubleRoom.getBeds());
            System.out.println("Size: " + doubleRoom.getSize() + " sqft");
            System.out.println("Price per night: " + doubleRoom.getPrice());
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        // Suite Room
        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room:");
            System.out.println("Beds: " + suiteRoom.getBeds());
            System.out.println("Size: " + suiteRoom.getSize() + " sqft");
            System.out.println("Price per night: " + suiteRoom.getPrice());
            System.out.println("Available: " + availability.get("Suite"));
            System.out.println();
        }
    }
}

/**
 * ============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ============================================================
 *
 * Demonstrates how guests can search
 * available rooms without modifying inventory
 */

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suite = new Room("Suite", 3, 750, 5000.0);

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(
                inventory,
                single,
                doubleRoom,
                suite);
    }
}