import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TripList {

    // method for loading and return all 13 trips.. from car A to car M
    public static ArrayList<Trip> getAllTrips() {

        ArrayList<Trip> trips = new ArrayList<>();
        // adding each car interval here

        Trip trip1 = new Trip(LocalTime.of(8, 0), LocalTime.of(16, 0), 10);
        Trip trip2 = new Trip(LocalTime.of(1, 0), LocalTime.of(8, 0), 50);
        Trip trip3 = new Trip(LocalTime.of(13, 0), LocalTime.of(21, 0), 42);
        Trip trip4 = new Trip(LocalTime.of(22, 0), LocalTime.of(23, 59), 20);
        Trip trip5 = new Trip(LocalTime.of(2, 0), LocalTime.of(4, 0), 13);
        Trip trip6 = new Trip(LocalTime.of(7, 0), LocalTime.of(12, 0), 20);
        Trip trip7 = new Trip(LocalTime.of(15, 0), LocalTime.of(19, 0), 10);
        Trip trip8 = new Trip(LocalTime.of(17, 0), LocalTime.of(23, 59), 35);
        Trip trip9 = new Trip(LocalTime.of(5, 0), LocalTime.of(10, 0), 15);
        Trip trip10 = new Trip(LocalTime.of(11, 0), LocalTime.of(14, 0), 45);
        Trip trip11 = new Trip(LocalTime.of(0, 1), LocalTime.of(6, 0), 30);
        Trip trip12 = new Trip(LocalTime.of(20, 0), LocalTime.of(23, 0), 18);
        Trip trip13 = new Trip(LocalTime.of(13, 0), LocalTime.of(18, 0), 20);
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

        HashMap <String,Trip> cars_and_interval = new HashMap<>();
        cars_and_interval.put("A", trip1);
        cars_and_interval.put("B", trip2);
        cars_and_interval.put("C", trip3);
        cars_and_interval.put("D", trip4);
        cars_and_interval.put("E", trip5);
        cars_and_interval.put("F", trip6);
        cars_and_interval.put("G", trip7);
        cars_and_interval.put("H", trip8);
        cars_and_interval.put("I", trip9);
        cars_and_interval.put("J", trip10);
        cars_and_interval.put("K", trip11);
        cars_and_interval.put("L", trip12);
        cars_and_interval.put("M", trip13);
//
//        for (Map.Entry<String, Trip> entry : cars_and_interval.entrySet()) {
//            System.out.println("Car " + entry.getKey() + " -> " + entry.getValue().getTrip());
//        }

        return trips;


    }

    public static void main(String[] args) {
        Trip main_interval = new Trip(LocalTime.of(00,00),LocalTime.of(23,59),Integer.MAX_VALUE);
        //driver has to work 12 hours per day
        int daily_trip_Hours = 12;

        ArrayList<Trip> allTrips = getAllTrips();

//        //first thing, i want to arrange all the trips _ this is starting from onwards
//        allTrips.sort(Comparator.comparing(Trip::getStartTime));

        //verify the number of cars loaded
        System.out.println("Total trips loaded: " + allTrips.size());
        for (Trip trip:allTrips)
            System.out.println(trip.getTrip());

        //sum of all the hours available to work for_ each trip
        int totalHours = 0;
        for(Trip trip:allTrips)
            totalHours +=  (trip.getFinishTime().getHour() - trip.getStartTime().getHour());

        System.out.println(" Total hours for all trips: " + totalHours +"hrs" );
        //System.out.println(allTrips.getLast().getTrip());

        //checking if i can print all 13 trips (already sorted)

        Trip[] optimal = new Trip[allTrips.size()];
        for(int i = 0 ; i < allTrips.size() - 1; i++){ //included the -1 because i'm tryna avoid out of bound exception
            if ( allTrips.get(i).getFinishTime().isBefore(allTrips.get(i+1).getStartTime()))
                optimal [i]= allTrips.get(i);
            else
                return;
        }
        System.out.println("printing optimal");
        System.out.println("Total optimal trips: "  + optimal.length);
//        for(Trip trip:allTrips){
//                System.out.println( trip.getTrip());
//        }



        //before we go optimal, trying to do this greedily...i will use the earliest finish
        //to take get the optimal solution

        //if getAllTrips().getLast().getFinishTime().

    }
    //check if the break taken within is exactly 30 minutes
    public boolean breakTime(Trip interval){
//       Trip main_interval = new Trip(LocalTime.of(00,00),LocalTime.of(23,59),Integer.MAX_VALUE);

       LocalTime allowedStartTime = interval.finish.plusMinutes(30);//adding the 30 min break
       if (!interval.start.isBefore(allowedStartTime)) //cannot work before allowed start time which is 30 min
           return true;

       return false;
    }

    //checking if he drives 12hrs per day

    public boolean workingHours(){

        return false;
    }


    public static void greedyApproach(Trip j ){

    }


}
