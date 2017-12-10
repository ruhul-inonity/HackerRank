package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by inonity on 11/28/17.
 */

//https://www.hackerrank.com/challenges/coin-change/problem


public class TheCoinChangeProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] coins = new int[M];
        for(int i = 0; i < M; i++) {
            coins[i] = scan.nextInt();
        }
        System.out.println(max(coins, N));
    }

    public static int max(int[] coins, int N) {
        int[] numCoins = new int[N+1];
        numCoins[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j < numCoins.length; j++) {
               // System.out.println("num coins j "+numCoins[j]+" coins j - coins i "+numCoins[j - coins[i]]);
                numCoins[j] += numCoins[j - coins[i]];
            }
        }
        return numCoins[N];
    }
}
