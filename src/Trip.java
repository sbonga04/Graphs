import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Trip {

    LocalTime start ;
    LocalTime finish;
    int capacity;

    Trip(LocalTime start, LocalTime finish, int capacity){
         this.start = start;
         this.finish = finish;
         this.capacity = capacity;

    }
    public int getCapacity() {
        return capacity;
    }
    public LocalTime getStartTime() {
        return start;
    }
    public LocalTime getFinishTime() {
        return finish;
    }
    public String getTrip(){
        return "Trip {start= " + this.start + ", finish= "+this.finish + " capacity= "+this.capacity +"}";
    }
//
//    Trip trip1 = new Trip(LocalTime.of(8, 0), LocalTime.of(16, 0), 10);
//    Trip trip2 = new Trip(LocalTime.of(1, 0), LocalTime.of(8, 0), 50);
//    Trip trip3 = new Trip(LocalTime.of(13, 0), LocalTime.of(21, 0), 42);
//    Trip trip4 = new Trip(LocalTime.of(22, 0), LocalTime.of(23, 59), 20);
//    Trip trip5 = new Trip(LocalTime.of(2, 0), LocalTime.of(4, 0), 13);
//    Trip trip6 = new Trip(LocalTime.of(7, 0), LocalTime.of(12, 0), 20);
//    Trip trip7 = new Trip(LocalTime.of(15, 0), LocalTime.of(19, 0), 10);
//    Trip trip8 = new Trip(LocalTime.of(17, 0), LocalTime.of(23, 59), 35);
//    Trip trip9 = new Trip(LocalTime.of(5, 0), LocalTime.of(10, 0), 15);
//    Trip trip10 = new Trip(LocalTime.of(11, 0), LocalTime.of(14, 0), 45);
//    Trip trip11 = new Trip(LocalTime.of(0, 1), LocalTime.of(6, 0), 30);
//    Trip trip12 = new Trip(LocalTime.of(20, 0), LocalTime.of(23, 0), 18);
//    Trip trip13 = new Trip(LocalTime.of(13, 0), LocalTime.of(18, 0), 20);
////
//    public static ArrayList<Trip> tripList = new ArrayList<>();
//        tripList.add(new Trip(LocalTime.of(8, 0), LocalTime.of(16, 0), 10));
//        tripList.add(trip2);
//        tripList.add(trip3);
//        tripList.add(trip4);
//        tripList.add(trip5);
//        tripList.add(trip6);
//        tripList.add(trip7);
//        tripList.add(trip8);
//        tripList.add(trip9);
//        tripList.add(trip10);
//        tripList.add(trip11);
//        tripList.add(trip12);
//        tripList.add(trip13);
//
////might consider this line for sorting the time trips
//        tripList.sort(Comparator.comparing(Trip::getStartTime));
}