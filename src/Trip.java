import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Trip {

    char car;
    LocalTime start ;
    LocalTime finish;
    int capacity;

    Trip(char car,LocalTime start, LocalTime finish, int capacity){
        this.car = car;
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
    public char getCar() {
        return car;
    }

    public String getTrip(){
        return "Car " + car + ": -> Trip {start= " + this.start + ", finish= "+this.finish + " capacity= "+this.capacity +"}";
    }

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