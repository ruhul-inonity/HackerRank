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
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] coins = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = scan.nextInt();
        }
        scan.close();

        System.out.println(numWays(n, coins));
    }

    public static long numWays(int n, int [] coins) {
        if (n < 0) {
            return 0;
        }
        return numWays(n, coins, 0, new HashMap<String, Long>());
    }

    public static long numWays(int n, int [] coins, int coinNumber, HashMap<String, Long> cache) {

        String key = n + "," + coinNumber;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (coinNumber == coins.length - 1) {
            if (n % coins[coinNumber] == 0) {
                cache.put(key, 1L);
                return 1;
            } else {
                cache.put(key, 0L);
                return 0;
            }
        }

        long ways = 0;
        for (int i = 0; i <= n; i += coins[coinNumber]) {
            ways += numWays(n - i, coins, coinNumber + 1, cache);
        }

        cache.put(key, ways);
        return ways;
    }
}
