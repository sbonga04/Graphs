import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Algorithms {

    public static void GreedyOptSchedule(ArrayList<Trip> interval) {
        //greedy approach..i will use the earliest finish
        //to take get the optimal solution


        long totalWorkHours = 10;
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
        System.out.println("2.a Optimal non-overlapping schedule size within 12 working hours: " + optimal.size());
        for (Trip t : optimal) {
            totalHours += t.getFinishTime().getHour() - t.getStartTime().getHour();
            System.out.println(t.getTrip());
        }
        System.out.println("total work hours: " + totalHours);

    }



    public static void dynamicApproach(ArrayList<Trip> interval){

        System.out.println("\n"+"""
                   DYNAMIC APPROACH """ + "\n");

        interval.sort(Comparator.comparing(Trip::getFinishTime));
        long totalWorkHours = 0;
        //looking for optimal jobs.. just like prevously so here i'll just copy and paste the code from above since it's the same
        ArrayList<Trip> optimal = new ArrayList<>();
        Trip before_trip = interval.getFirst();
        optimal.add(before_trip);


        for (int i =1 ; i < interval.size(); i ++){

            Trip current_trip = interval.get(i);
            //apply the restriction
            long tripDuration = ChronoUnit.HOURS.between(current_trip.getStartTime(), current_trip.getFinishTime());
            if (tripDuration + totalWorkHours > 12)
                break;

            if (current_trip.getStartTime().isAfter(before_trip.getFinishTime())){
                optimal.add(current_trip);
                before_trip = current_trip;

                totalWorkHours += tripDuration;
            }
            //up until here... now we now know who's on the optimal schedule
            //and also less than 12hour bound

        }

/*
        set this up for testing if opt jobs can be printed
*/

        int totalHours = 0;
        System.out.println("2d.Optimal non-overlapping schedule size within 12 working hours: " + optimal.size());
        for (Trip t : optimal) {totalHours += t.getFinishTime().getHour() - t.getStartTime().getHour();
            System.out.println(t.getTrip());
        }
        System.out.println("total work hours: " + totalHours);

        //part of the Dynamic programming(memoization) step, not the recurssion kind

        int [] M = new int[optimal.size()];
        //Here... need some type of base case
        M[0] = optimal.getFirst().capacity;
        int max_capacity = M[0];

        for (int trip = 0; trip<optimal.size(); trip ++) {
            //writing capacity to the Memoized array
            M[trip] =  optimal.get(trip).getCapacity();

        }

        Arrays.sort(M);// sorting from up and taking the best from the 3
        int total_capacity = 0;
        ArrayList<Integer> M_opt = new ArrayList<>();
        for (int x = M.length - 1; x >= 0; x--) {       // o(n)
            total_capacity += M[x];
            M_opt.add(M[x]);
        }
        System.out.println(M_opt);
        int maxCapacity = M[M.length-1];

        System.out.println("total capacity: " + total_capacity);
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

