import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Comparator;

public class TripList {

    // method for loading and return all 13 trips.. from car A to car M
    public static ArrayList<Trip> getAllTrips() {

        ArrayList<Trip> trips = new ArrayList<>();
        // adding each car interval here
        trips.add(new Trip(LocalTime.of(8, 0), LocalTime.of(16, 0), 10));
        trips.add(new Trip(LocalTime.of(1, 0), LocalTime.of(8, 0), 50));
        trips.add(new Trip(LocalTime.of(13, 0), LocalTime.of(21, 0), 42));
        trips.add(new Trip(LocalTime.of(22, 0), LocalTime.of(23, 59), 20));
        trips.add(new Trip(LocalTime.of(2, 0), LocalTime.of(4, 0), 13));
        trips.add(new Trip(LocalTime.of(7, 0), LocalTime.of(12, 0), 20));
        trips.add(new Trip(LocalTime.of(15, 0), LocalTime.of(19, 0), 10));
        trips.add(new Trip(LocalTime.of(17, 0), LocalTime.of(23, 59), 35));
        trips.add(new Trip(LocalTime.of(5, 0), LocalTime.of(18, 0), 15));
        trips.add(new Trip(LocalTime.of(11, 0), LocalTime.of(14, 0), 45));
        trips.add(new Trip(LocalTime.of(0, 1), LocalTime.of(6, 0), 30));
        trips.add(new Trip(LocalTime.of(20, 0), LocalTime.of(23, 0), 18));
        trips.add(new Trip(LocalTime.of(13, 0), LocalTime.of(18, 0), 20));

        return trips;
    }

    public static void main(String[] args) {
        ArrayList<Trip> allTrips = getAllTrips();
        //first thing, i want to arrange all the trips _ this is starting from earliest finishtime onwards
        allTrips.sort(Comparator.comparing(Trip::getStartTime));

        //verify the number of cars loaded
        System.out.println("Total trips loaded: " + allTrips.size());
        //System.out.println(allTrips.getLast().getTrip());

        //checking if i can print all 13 trips
        for(Trip trip:allTrips)
            System.out.println( trip.getTrip());
    }


}
