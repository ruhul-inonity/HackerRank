package util;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by inonity on 11/28/17.
 */

//https://www.hackerrank.com/challenges/coin-change/problem


public class Test {

        static BigInteger sumOfGroup(int k) {
            BigInteger answer = BigInteger.valueOf(k).pow(3);
            /*long result = 1;
            if(k == 1)
                result =  1;
            else if(k == 2)
                result =  8;
            else if(k > 2){
                result =  (long) Math.pow(k, 3);
            }
            return result;*/
            return answer;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            BigInteger answer = sumOfGroup(k);
            System.out.println(answer);
            in.close();
        }


}
