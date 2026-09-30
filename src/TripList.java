import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalTime;

import static java.lang.Math.max;

public class TripList {

    // method for loading and return all 13 trips.. from car A to car M
    public static void main(String[] args) {

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

        HashMap<Character, Trip> cars_and_interval = new HashMap<>();
        cars_and_interval.put('A', trip1);
        cars_and_interval.put('B', trip2);
        cars_and_interval.put('C', trip3);
        cars_and_interval.put('D', trip4);
        cars_and_interval.put('E', trip5);
        cars_and_interval.put('F', trip6);
        cars_and_interval.put('G', trip7);
        cars_and_interval.put('H', trip8);
        cars_and_interval.put('I', trip9);
        cars_and_interval.put('J', trip10);
        cars_and_interval.put('K', trip11);
        cars_and_interval.put('L', trip12);
        cars_and_interval.put('M', trip13);
//
//        for (Map.Entry<Character, Trip> entry : cars_and_interval.entrySet()) {
//            System.out.println("Car " + entry.getKey() + " -> " + entry.getValue().getTrip());
//

        Trip main_interval = new Trip(LocalTime.of(00,00),LocalTime.of(23,59),Integer.MAX_VALUE);
        //driver has to work 12 hours per day
        int daily_trip_Hours = 12;

        ArrayList<Trip> allTrips = trips;

//        //first thing, i want to arrange all the trips _ this is starting from onwards
//        allTrips.sort(Comparator.comparing(Trip::getStartTime));

        //verify the number of cars loaded
        System.out.println("Total trips loaded: " + allTrips.size());
//        for (Trip trip:allTrips)
//            System.out.println(trip.getTrip());

        //sum of all the hours available to work for_ each trip
        int totalHours = 0;
        for(Trip trip:allTrips)
            totalHours +=  (trip.getFinishTime().getHour() - trip.getStartTime().getHour());

        System.out.println(" Total hours for all trips: " + totalHours +"hrs" );
        //System.out.println(allTrips.getLast().getTrip());

        //checking if i can print all 13 trips (already sorted)


        for(Trip trip:allTrips){
            System.out.println( trip.getTrip());
        }

        System.out.println("\n");
        GreedyOptSchedule(allTrips);

        dynamicApproach(allTrips);

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


    public static void GreedyOptSchedule(ArrayList<Trip> interval) {

        long totalWorkHours = 12;
        //first thing _ sorting the interval
        interval.sort(Comparator.comparing(Trip::getFinishTime));

        ArrayList<Trip> optimal = new ArrayList<>(); //keeping this array for later optimal trip
        //now after sorting... i want to take the first job
        Trip before_trip = interval.getFirst(); //getting the first job

        long workHours = 0;

        optimal.add(before_trip);
        for (int elementI = 1; elementI < interval.size(); elementI++) { //taking the next trip after the 1st one on index(0) that was before_trip

            Trip current_trip = interval.get(elementI); //this is the current trip 1
            long tripDuration = ChronoUnit.HOURS.between(before_trip.getStartTime(), current_trip.getFinishTime());


            //i will try and enforce the 12hour duration
            if (workHours + totalWorkHours > 12)
                continue;
            //for this case, checking who's who and who's not.
            if (current_trip.getStartTime().isAfter(before_trip.getFinishTime())) {
                optimal.add(current_trip);//append to my array
                before_trip = current_trip;//saving this trip to be the one to compare as "before" for next comparison

                workHours += tripDuration;
            }

        }//testing to see if it can print the optimal jobs..
        int totalHours = 0;
        System.out.println("Optimal non-overlapping schedule size within 12 working hours: " + optimal.size());
        for (Trip t : optimal) {
            totalHours += t.getFinishTime().getHour() - t.getStartTime().getHour();
            System.out.println(t.getTrip());
        }
        System.out.println("total work hours: " + totalHours);

    }

    public static void dynamicApproach(ArrayList<Trip> interval){

        System.out.println("\n\n"+"""
                   !!!!!!!!calling THE DYNAMIC APPROACH !!!!!!!!!!!!!!!!!""" + "\n");

        interval.sort(Comparator.comparing(Trip::getFinishTime));
        long totalWorkHours = 12;
        //looking for optimal jobs.. just like prevously so here i'll just copy and paste the code from above since it's the same
        ArrayList<Trip> optimal = new ArrayList<>();
        Trip before_trip = interval.getFirst();
        optimal.add(before_trip);

        long workHours = 0;
        for (int i =1 ; i < interval.size(); i ++){

            Trip current_trip = interval.get(i);

            long tripDuration = ChronoUnit.HOURS.between(before_trip.getStartTime(), current_trip.getFinishTime());
            //i will try and enforce the 12hour duration
            if (workHours + totalWorkHours > 12)
                continue;

            if (current_trip.getStartTime().isAfter(before_trip.getFinishTime())){
                optimal.add(current_trip);
                before_trip = current_trip;

                totalWorkHours += tripDuration;
            }
            //up until here... we now know who's on the optimal schedule

        }

/*
         set this up for testing if opt jobs can be printed
*/
        int totalHours = 0;
                System.out.println("Optimal non-overlapping schedule size: " + optimal.size());
                System.out.println("Optimal non-overlapping schedule size within 12 working hours: " + optimal.size());
        for (Trip t : optimal) {
            totalHours += t.getFinishTime().getHour() - t.getStartTime().getHour();
            System.out.println(t.getTrip());
        }
        System.out.println("total work hours: " + totalHours);


        //Here... need some type of base case
        int [] M = new int[optimal.size()];
        M[0] = optimal.getFirst().capacity;

        for (int trip = 1; trip<optimal.size(); trip ++) {
            //this operation = taking the value of the first M[0] and adding the current_trip.capacity
            //assigning all that to M[1]
            M[trip] = M[trip - 1] + optimal.get(trip).getCapacity();
        }

        int maxCapacity = M[M.length-1];
        System.out.println(Arrays.toString(M));
        System.out.println("Maximum total capacity obtained was: " + maxCapacity);
                //testin
        /*    int totalHours = 0;
            System.out.println("optimal non-overlapping schedule size within 12 hours: " + optimal.size());
            for (Trip t: optimal) {
                totalHours += t.getFinishTime().getHour() - t.getStartTime().getHour();
                System.out.println(t.getTrip());
            }
            System.out.println("total work hours: " + totalHours );
        */}
}
