import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * Room pricing and characteristics are obtained
 * from Room objects, not duplicated here.
 *
 * This avoids multiple sources of truth and
 * keeps responsibilities clearly separated.
 *
 * @version 3.1
 */

class UC3 {

    // Key -> Room type
    // Value -> Available room count
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory
     * with default availability values.
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data.
     */
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Returns the current availability map.
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Updates availability for a specific room type.
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

/**
 * Room class representing room characteristics
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
 * MAIN CLASS - UseCase3InventorySetup
 * ============================================================
 *
 * Demonstrates centralized room inventory management
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suite = new Room("Suite", 3, 750, 5000.0);

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Hotel Room Inventory Status\n");

        printRoom(single, availability.get(single.getType()));
        printRoom(doubleRoom, availability.get(doubleRoom.getType()));
        printRoom(suite, availability.get(suite.getType()));
    }

    private static void printRoom(Room room, int available) {

        System.out.println(room.getType() + " Room:");
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Available Rooms: " + available);
        System.out.println();
    }
}