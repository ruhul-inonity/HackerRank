package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by inonity on 11/22/18.
 */



public class TheCoinChangeProblemGivenSum {

    static ArrayList<ArrayList<Integer>> combList;
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x: partial) s += x;
        if (s <= target)
            combList.add(partial);
        if (s >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        combList = new ArrayList<>();
        Integer[] numbers = {3,9,8,4,5,7,10};
        int target = 20;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);

        for (int i = 0; i < combList.size(); i++) {
            System.out.println( combList.get(i).size());
        }
    }
}
