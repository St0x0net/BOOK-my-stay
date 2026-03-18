import java.util.*;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * Demonstrates how booking requests are confirmed and rooms
 * are allocated safely using FIFO processing.
 *
 * Ensures:
 * - Unique room IDs
 * - No double-booking
 * - Immediate inventory update
 *
 * @version 6.0
 */
public class Bookmystay {

    /**
     * Represents a booking request.
     */
    static class Reservation {
        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    /**
     * Handles room allocation and booking confirmation.
     */
    static class RoomAllocationService {

        // Stores all allocated room IDs (prevents duplicates)
        private Set<String> allocatedRoomIds;

        // Maps room type -> assigned room IDs
        private Map<String, Set<String>> assignedRoomsByType;

        // Stores available inventory
        private Map<String, Integer> inventory;

        /**
         * Constructor to initialize data structures.
         */
        public RoomAllocationService(Map<String, Integer> inventory) {
            this.allocatedRoomIds = new HashSet<>();
            this.assignedRoomsByType = new HashMap<>();
            this.inventory = inventory;
        }

        /**
         * Confirms a booking request.
         */
        public void confirmBooking(Reservation reservation) {
            String roomType = reservation.getRoomType();

            // Step 1: Check availability
            if (!inventory.containsKey(roomType) || inventory.get(roomType) <= 0) {
                System.out.println("Booking failed for Guest: "
                        + reservation.getGuestName()
                        + " (No rooms available for type: " + roomType + ")");
                return;
            }

            // Step 2: Generate unique room ID
            String roomId = generateRoomId(roomType);

            // Step 3: Record allocation
            allocatedRoomIds.add(roomId);
            assignedRoomsByType
                    .computeIfAbsent(roomType, k -> new HashSet<>())
                    .add(roomId);

            // Step 4: Update inventory immediately
            inventory.put(roomType, inventory.get(roomType) - 1);

            // Step 5: Confirm booking
            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: " + roomId);
        }

        /**
         * Generates a unique room ID.
         */
        private String generateRoomId(String roomType) {
            int counter = 1;
            String roomId;

            do {
                roomId = roomType + "-" + counter;
                counter++;
            } while (allocatedRoomIds.contains(roomId));

            return roomId;
        }
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        // Step 1: Initialize inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Suite", 1);

        // Step 2: Initialize allocation service
        RoomAllocationService service = new RoomAllocationService(inventory);

        // Step 3: Create FIFO queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));
        bookingQueue.add(new Reservation("Rahul", "Single")); // Should fail

        // Step 4: Process queue (FIFO)
        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            service.confirmBooking(reservation);
        }
    }
}