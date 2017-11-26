package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ruhul on 5/16/17.
 */

//www.hackerrank.com/challenges/big-sorting/problem


public class BigSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        sortLargeNumbers(unsorted);
        for (String i: unsorted) {
            System.out.println(i+" ");
        }
    }

    static void sortLargeNumbers(String arr[])
    {
        Arrays.sort(arr, (left, right) ->
        {
            if (left.length() != right.length()){
                return left.length() - right.length();
            }
            return left.compareTo(right);
        });
    }


    /*static void sortLargeNumbers(String arr[])
    {
        // Refer below post for understanding below expression:
        // http://www.geeksforgeeks.org/lambda-expressions-java-8/
        Arrays.sort(arr, (left, right) ->
        {
            System.out.println("left "+left+" --- right "+right);
            *//* If length of left != right, then return
               the diff of the length else  use compareTo
               function to compare values.*//*
            if (left.length() != right.length()){

                System.out.println(left.length() - right.length());
                return left.length() - right.length();
            }
            return left.compareTo(right);
        });
    }

    // Driver code
    public static void main(String args[])
    {
        String arr[] = {"5", "1237637463746732323",
                "97987", "12" };
        sortLargeNumbers(arr);
        for (String s : arr)
            System.out.print(s + " ");
    }*/
}
