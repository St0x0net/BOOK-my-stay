/**
 * =========================================================
 * MAIN CLASS - UseCase2HotelBookingApp
 * =========================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Demonstrates abstraction and inheritance using
 * different room types in a hotel booking system.
 */

public class App {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("      Book My Stay Application      ");
        System.out.println("      Hotel Booking System v2.0     ");
        System.out.println("====================================");

        // Static availability variables
        int singleRoomAvailable = 10;
        int doubleRoomAvailable = 6;
        int suiteRoomAvailable = 3;

        // Create room objects using polymorphism
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("\nSingle Room Details:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailable);

        System.out.println("\nDouble Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailable);

        System.out.println("\nSuite Room Details:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailable);

        System.out.println("\nApplication finished.");
    }
}


/**
 * =========================================================
 * ABSTRACT CLASS - Room
 * =========================================================
 *
 * Represents a generic hotel room.
 *
 * @version 2.1
 */
abstract class Room {

    /** Number of beds available in the room. */
    protected int numberOfBeds;

    /** Total size of the room in square feet. */
    protected int squareFeet;

    /** Price charged per night for this room type. */
    protected double pricePerNight;

    /**
     * Constructor for Room
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /** Displays room details */
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Room Size: " + squareFeet + " sq ft");
        System.out.println("Price Per Night: ₹" + pricePerNight);
    }
}


/**
 * =========================================================
 * CLASS - SingleRoom
 * =========================================================
 *
 * Represents a single room in the hotel.
 *
 * @version 2.1
 */
class SingleRoom extends Room {

    /** Initializes a SingleRoom with predefined attributes */
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


/**
 * =========================================================
 * CLASS - DoubleRoom
 * =========================================================
 *
 * Represents a double room in the hotel.
 *
 * @version 2.1
 */
class DoubleRoom extends Room {

    /** Initializes a DoubleRoom with predefined attributes */
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


/**
 * =========================================================
 * CLASS - SuiteRoom
 * =========================================================
 *
 * Represents a suite room in the hotel.
 *
 * @version 2.1
 */
class SuiteRoom extends Room {

    /** Initializes a SuiteRoom with predefined attributes */
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}