package personal.darxan.hostel.jmx.algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.*;
/**
 * Created by darxan on 2017/3/3.
 */
public class Main {


    private static int startIndex = -2;

    static BigInteger add(int[] A, BigInteger partSum) {
        BigInteger sum = BigInteger.ZERO;
        for ( startIndex+=2; startIndex<A.length ;startIndex++) {
            sum = sum.add(new BigInteger(A[startIndex]+""));
            if (sum.compareTo(partSum)>=0) {
                return sum;
            }
        }
        return sum;
    }

    static BigInteger getNeighborSum(int[] A, BigInteger partSum) {
        BigInteger sum = BigInteger.ZERO;
        for ( int i = 0; i<A.length ;i++) {
            BigInteger tempSum = sum.add(new BigInteger(A[i]+""));
            if (tempSum.compareTo(partSum)>=0) {
                break;
            }else {
                sum = tempSum;
            }
        }
        System.out.print("choose sum: ");
        System.out.println(sum);
        return sum;
    }

    static boolean resolve(int[] A) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger _devide = new BigInteger("4");
        for (int a : A) {
            sum = sum.add(new BigInteger(a+""));
            System.out.println(sum.intValue());
        }
        BigInteger partSum = sum.divide(_devide);

        do {
            partSum = getNeighborSum(A, partSum);
            startIndex = -2;

                for (int i = 0; i<4; i++) {
                    BigInteger slice = add(A, partSum);
                    if (!slice.equals(partSum)) {
                        break;
                    } else if (i==3){
                        return true;
                    }
                }

        }while (BigInteger.ZERO!=partSum);

        return false;
    }

    public static void main(String[] args) {
        int[] A={2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
        System.out.println(resolve(A));;
    }

    static void test() {
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        lock.newCondition();
    }


}
