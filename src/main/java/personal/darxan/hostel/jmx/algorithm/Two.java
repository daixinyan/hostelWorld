package personal.darxan.hostel.jmx.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * Created by darxan on 2017/3/3.
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
public class Two {

    /**
     * sum是该数组所有项之和
     */
    private static BigInteger sum;
    /**
     * SS[i]是该数组前i项之和，SS[A.length-1] = sum
     */
    private static BigInteger[] SS;

    /**
     * separator表示的是 三个下标 <strong>m1, m2, m3</strong>
     * firstSeparator 等价于 m1
     * mid 等价于 m2
     * lastSeparator 等价于 m2
     *
     * map_SSm_SSmp1ToM这个数据结构：
     * 表示 SS[separator]+SS[separator-1] -> separator 的映射结构
     *
     * 对于任意点为中间一个节点的切片集合， 左右两边各包含两个切片
     * 对于还未有分割的左右两端：
     * 如果可以切割,并且切分符号为firstSeparator，lastSeparator：
     * 对于头部： SS[mid-1] - SS[firstSeparator] = SS[firstSeparator-1] - SS[0]
     * =======>  SS[mid-1] = SS[firstSeparator] + SS[firstSeparator-1]
     *
     * 对于末尾： sum - SS[lastSeparator] = SS[lastSeparator-1] - SS[mid]
     * =======>  sum + SS[mid]  = SS[lastSeparator-1] + SS[lastSeparator]
     *
     *
     * 把 SS[lastSeparator-1] + SS[lastSeparator] => separator放入map,
     * 对于每一个mid(m2,也就是第二个分隔字符)，
     * 都可以通过map获得firstSeparator（m1），lastSeparator(m3)
     *
     */
    private static HashMap<BigInteger, List<Integer>> map_SSm_SSmp1ToM;

    private static void putInteger(BigInteger key, Integer integer) {
        List<Integer> value = map_SSm_SSmp1ToM.get(key);
        if (value==null) {
            value = new ArrayList<Integer>();
        }
        value.add(integer);
        map_SSm_SSmp1ToM.put(key, value);
    }


    static void print(Object o) {
//        System.out.print(o);
    }
    static void println() {
//        System.out.println();
    }
    static void println(Object o) {
//        System.out.println(o);
    }

    /**
     * 对每个mid（m2）值，在常量时间内尝试解决
     * 理想状态下，map.get()视为常量时间
     * @param A
     * @param mid
     * @return
     */
    static HashSet<BigInteger> leftPartSet = new HashSet<BigInteger>();
    static boolean trySolveByMid(int[] A, int mid) {
        //SS[mid-1]+SS[0]
        List<Integer> firstSliceList = map_SSm_SSmp1ToM.get(SS[mid-1]);
        println("getLeft:"+mid);
        println(SS[mid-1]);
        println(firstSliceList);
        if (firstSliceList==null||firstSliceList.size()==0) {
            return false;
        }
        //SS[end]+SS[mid]
        List<Integer> lastSliceList = map_SSm_SSmp1ToM.get(SS[mid].add(sum));
        println("getright:"+mid);
        println(SS[mid].add(sum));
        println(lastSliceList);
        println();
        if (lastSliceList==null||lastSliceList.size()==0) {
            return false;
        }

        leftPartSet.clear();
        for (Integer firstSlice: firstSliceList) {
            if (firstSlice>=mid) continue;
            BigInteger leftPartSum = SS[mid-1].subtract(SS[firstSlice]);
            leftPartSet.add(leftPartSum);
        }
        for (Integer lastSlice: lastSliceList) {
            if (lastSlice<=mid) continue;
            BigInteger rightPartSum = sum.subtract(SS[lastSlice]);
            if (leftPartSet.contains(rightPartSum)) {
                return true;
            }
        }

        return false;
    }

    static boolean resolve(int[] A) {
        init(A);
        for (int i=3; i<A.length; i++) {
            if (trySolveByMid(A, i))
                return true;
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

        sum = BigInteger.ZERO;
        map_SSm_SSmp1ToM = new HashMap<BigInteger, List<Integer>>(A.length*15);
        SS = new BigInteger[A.length];

        for (int i=0; i<A.length; i++) {
            int a = A[i];
            sum = sum.add(new BigInteger(a+""));
            SS[i] = sum;
            putInteger(SS[i].add(i>0?SS[i-1]:BigInteger.ZERO), i);
        }

    }
}
