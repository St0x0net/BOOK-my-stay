import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * CLASS - Reservation
 * ============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class represents a booking request
 * made by a guest.
 *
 * At this stage, a reservation only captures
 * intent, not confirmation or room allocation.
 *
 * @version 5.0
 */

class Reservation {

    /** Name of the guest making the booking */
    private String guestName;

    /** Requested room type */
    private String roomType;

    /**
     * Creates a new booking request
     */
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    /** return guest name */
    public String getGuestName() {
        return guestName;
    }

    /** return requested room type */
    public String getRoomType() {
        return roomType;
    }
}

/**
 * ============================================================
 * CLASS - BookingRequestQueue
 * ============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class manages booking requests
 * using a queue to ensure fair allocation.
 *
 * Requests are processed strictly
 * in the order they are received.
 *
 * @version 5.0
 */

class BookingRequestQueue {

    private Queue<Reservation> bookingQueue;

    public BookingRequestQueue() {
        bookingQueue = new LinkedList<>();
    }

    /** Add booking request to queue */
    public void addRequest(Reservation reservation) {
        bookingQueue.add(reservation);
    }

    /** Process next booking request (FIFO) */
    public Reservation processRequest() {
        return bookingQueue.poll();
    }

    /** Check if queue is empty */
    public boolean isEmpty() {
        return bookingQueue.isEmpty();
    }
}

/**
 * ============================================================
 * MAIN CLASS - UseCase5BookingRequest
 * ============================================================
 *
 * Demonstrates booking request queue
 * handling using FIFO principle
 */

public class UseCase5BookingRequest {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        // Guests submitting booking requests
        Reservation r1 = new Reservation("Rahul", "Single");
        Reservation r2 = new Reservation("Anita", "Double");
        Reservation r3 = new Reservation("Vikram", "Suite");

        // Add requests to queue
        queue.addRequest(r1);
        queue.addRequest(r2);
        queue.addRequest(r3);

        System.out.println("Processing Booking Requests (FIFO)\n");

        while (!queue.isEmpty()) {

            Reservation current = queue.processRequest();

            System.out.println("Guest: " + current.getGuestName());
            System.out.println("Requested Room: " + current.getRoomType());
            System.out.println();
        }
    }
}