import java.util.Arrays;

public class Jobs {


    public static void compSchedule(Interval[] intervals){

        Arrays.sort(intervals);

        int size = intervals.length;

        //want to see the one that stores the non-overlapping interval
        //1. calculate p(j) for each interval
        int optimal[] = new int[size + 1];
        for (int j = 1; j < size; j++){
            optimal[j] = 0;       //if there's no non-overlapping job found

            //look for the the non- overlapping
            for( int i = j -1 ; i >= 1 ; i --){     //start forward and work backwards

                if (intervals [i-1].finish < intervals[j-1].start) {
                    optimal[j] = i;
                    break;
                }
            }

        }

        //2.compute the max-value array

    }
}
