package personal.darxan.hostel.jmx.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by darxan on 2017/3/4.
 * 对于一个长度为N的整型数组A， 数组里所有的数都是正整数，对于两个满足
 * 0<=X <= Y <N的整数，A[X], A[X+1] … A[Y]构成A的一个切片，记作(X, Y)。
 用三个下标 m1, m2, m3下标满足条件 0 < m1, m1 + 1 < m2, m2 +1 < m3 < N – 1。
 可以把这个整型数组分成(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1) 四个切片。
 如果这四个切片中的整数求和相等，称作“四等分”。
 编写一个函数，求一个给定的整型数组是否可以四等分，如果可以，返回一个布尔类型的true，
 如果不可以返回一个布尔类型的false。
 限制条件： 数组A最多有1,000,000项，数组中的整数取值范围介于-1,000,000到1,000,000之间。
 要求： 函数的计算复杂度为O(N)，使用的额外存储空间（除了输入的数组之外）最多为O(N)。
 例子：
 对于数组A=[2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7] 存在下标 2, 7, 9
 使得数组分成四个分片[2, 5], [1, 1, 1, 4], [7], [7]，这三个分片内整数之和相等，所以对于这个数组，函数应该返回true。
 对于数组 A=[10, 2, 11, 13, 1, 1, 1, 1, 1]， 找不到能把数组四等分的下标，所以函数应该返回false。
 */
public class Three {

    /**
     * sum是该数组所有项之和
     */
    private static Long sum;
    /**
     * SS[i]是该数组前i项之和，SS[A.length-1] = sum
     */
    private static Long[] SS;


    /**
     * 是从右边开始累积：A[end-1]+A[end-2]+...+A[i] => i-1的映射
     */
    private static HashMap<Long,List<Integer>> rightSumToIndex;
    private static void putRightSumToIndex(Long key, Integer index) {
        List<Integer> value = rightSumToIndex.get(key);
        if (value==null) {
            value = new ArrayList<Integer>();
        }
        value.add(index);
        rightSumToIndex.put(key, value);
    }

    /**
     * 是从右边开始累积：A[end-1]+A[end-2]+...+A[i] => i的映射
     */
    private static HashMap<Long,List<Integer>> valueToIndex;
    private static void putValueToIndex(Long key, Integer index) {
        List<Integer> value = valueToIndex.get(key);
        if (value==null) {
            value = new ArrayList<Integer>();
        }
        value.add(index);
        valueToIndex.put(key, value);
    }

    static void print(Object o) {
        System.out.print(o);
    }
    static void println() {
        System.out.println();
    }
    static void println(Object o) {
        System.out.println(o);
    }


    static boolean resolve(int[] A) {
        init(A);

        for (int firstSeparator=1; firstSeparator<A.length-5; firstSeparator++) {

            List<Integer> lastSeparators = rightSumToIndex.get(SS[firstSeparator-1]);
            if (lastSeparators==null || lastSeparators.size()==0)
                continue;

            for (Integer lastSeparator: lastSeparators) {
                if (lastSeparator<firstSeparator) {
                    //这里因为列表是有序的，从N-0，
                    // 所以出现一个lastSeparator<firstSeparator，
                    // 后续的均满足lastSeparator<firstSeparator
                    break;
                }

                //此时已经知道了第一个与最后一个分隔符：firstSeparator，lastSeparator
                //已经知道每个切片之和应当为 partSum = SS[firstSeparator-1] == SS[end]-SS[lastSeparator]
                //所以可以计算出中间那个分隔符应当为多少 mid
                //A[mid] == sum-4*partSum-SS[firstSeparator]-SS[lastSeparator]
                long midValue = sum - 4*SS[firstSeparator-1] - A[firstSeparator] - A[lastSeparator];

                List<Integer> midIndexes = valueToIndex.get(midValue);

                if (midIndexes==null) {
                    continue;
                }

                for (Integer mid: midIndexes) {
                    if (mid>firstSeparator&&mid<lastSeparator) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] A={2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
//        int[] A={10, 2, 11, 13, 1, 1, 1, 1, 1};
//        int[] A={1,1,1,1,1,4,0,4,0,4};
        int[] A={1,1,0,0,0,0,1,1,1,-1,1,4,0,1,1,1,1,0,4,-4,4,8,-8};
        System.out.println(resolve(A));
    }

    static void init(int[] A) {

        SS = new Long[A.length];

        valueToIndex = new HashMap<Long, List<Integer>>(A.length*16);

        rightSumToIndex = new HashMap<Long, List<Integer>>(A.length*16);

        for (int i=0; i<A.length; i++) {
            putValueToIndex(new Long(A[i]), i);
        }

        sum = 0L;
        for (int i=0; i<A.length; i++) {
            long a = A[i];
            sum = sum+a;
            SS[i] = sum;
        }

        sum = 0L;
        for (int i=A.length-1; i>=0; i--) {
            long a = A[i];
            sum = sum+a;
            putRightSumToIndex(sum, i-1);
        }

    }
}
