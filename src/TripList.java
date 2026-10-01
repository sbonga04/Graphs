import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalTime;

import static java.lang.Math.max;

public class TripList {

    // method for loading and return all 13 trips.. from car A to car M
    public static void main(String[] args) {

        Trip trip1 = new Trip('A',LocalTime.of(8, 0), LocalTime.of(16, 0), 10);
        Trip trip2 = new Trip('B', LocalTime.of(1, 0), LocalTime.of(8, 0), 50);
        Trip trip3 = new Trip('C', LocalTime.of(13, 0), LocalTime.of(21, 0), 42);
        Trip trip4 = new Trip('D', LocalTime.of(22, 0), LocalTime.of(23, 59), 20);
        Trip trip5 = new Trip('E', LocalTime.of(2, 0), LocalTime.of(4, 0), 13);
        Trip trip6 = new Trip('F', LocalTime.of(7, 0), LocalTime.of(12, 0), 20);
        Trip trip7 = new Trip('G', LocalTime.of(15, 0), LocalTime.of(19, 0), 10);
        Trip trip8 = new Trip('H', LocalTime.of(17, 0), LocalTime.of(23, 59), 35);
        Trip trip9 = new Trip('I', LocalTime.of(5, 0), LocalTime.of(10, 0), 15);
        Trip trip10 = new Trip('J', LocalTime.of(11, 0), LocalTime.of(14, 0), 45);
        Trip trip11 = new Trip('K', LocalTime.of(0, 1), LocalTime.of(6, 0), 30);
        Trip trip12 = new Trip('L', LocalTime.of(20, 0), LocalTime.of(23, 0), 18);
        Trip trip13 = new Trip('M', LocalTime.of(13, 0), LocalTime.of(18, 0), 20);
        //thinking of considering basic arrays.. but i'll see later
        //Trip interval[] = new Trip[20];

        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
        trips.add(trip4);
        trips.add(trip5);
        trips.add(trip6);
        trips.add(trip7);
        trips.add(trip8);
        trips.add(trip9);
        trips.add(trip10);
        trips.add(trip11);
        trips.add(trip12);
        trips.add(trip13);
        //first thing, i want to arrange all the trips _ this is starting from onwards
        trips.sort(Comparator.comparing(Trip::getStartTime));

//        for (Map.Entry<Character, Trip> entry : cars_and_interval.entrySet()) {
//            System.out.println("Car " + entry.getKey() + " -> " + entry.getValue().getTrip());
//
        //driver has to work 12 hours per day
        int daily_trip_Hours = 12;

        ArrayList<Trip> allTrips = trips;
        //verify the number of trips/jobs loaded
        System.out.println("Total trips loaded: " + allTrips.size());

        //sum of all the hours available to work for_ each trip
        int totalHours = 0;
        for(Trip trip:allTrips)
            totalHours +=  (trip.getFinishTime().getHour() - trip.getStartTime().getHour());

        System.out.println(" Total hours for all trips: " + totalHours +"hrs" );

        //before we go optimal, trying to do this greedily...i will use the earliest finish
        //to take get the optimal solution

        }

}


