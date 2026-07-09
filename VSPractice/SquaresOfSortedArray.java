import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>() ;

        for(int num : arr) {
            if(num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        int[] positive = new int[pos.size()];
        int[] negative = new int[neg.size()];

        for(int i = 0; i < pos.size(); i++) {
            positive[i] = pos.get(i);
        }

        for(int i = 0; i < neg.size(); i++) {
            negative[i] = neg.get(i);
        }

        //Squaring of positive array
        for(int i=0;i<positive.length;i++){
            positive[i]*=positive[i];
        }

        //Squaring of negative array
        for(int i=0;i<negative.length;i++){
            negative[i]*=negative[i];
        }

        Arrays.sort(negative);

        int n = negative.length;
        int m = positive.length;

        List<Integer> sortedList = new ArrayList<>();
        //using 2 pointers pattern
        int i = 0, j = 0;
        while(i < n && j < m){
            if(negative[i] <= positive[j]){
                sortedList.add(negative[i]);
                i++;
            } else{
                sortedList.add(positive[j]);
                j++;
            }
        }
        while(j < m){
            sortedList.add(positive[j]);
            j++;
        }
        while(i < n){
            sortedList.add(negative[i]);
            i++;
        }

        System.out.println(sortedList);
    }
}
