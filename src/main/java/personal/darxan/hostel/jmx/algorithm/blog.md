阿里17实习生编程练习
=========

* 亮题
```
 对于一个长度为N的整型数组A， 数组里所有的数都是正整数，对于两个满足 0<=X <= Y <N的整数，A[X], A[X+1] … A[Y]构成A的一个切片，记作(X, Y)。
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
```

* 题感
    * 首先要注意到(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1)这四个切片虽然是小括号，
    但是是inclusive的，[0, m1-1], [m1+1, m2-1], [m2+1, m3-1], [m3+1, N-1]
    * 三个下标都不计入切片和
    * 越界问题，1 000 000*2的话，其实long也够了
    * 题目并不要求找到，只要求判断。 简单思考便可知下标组不唯一
    * 时间复杂度跟空间复杂度都是O（n），对这里是存心跟你为难

<br/> 
    我解题时直接看错题意了，这就不提。没看错我半小时也做不出来。<br/>
    * 对三个下标排列组合一遍，每个情况下判断是否存在 O(n^3)
    * 对第一个分割点遍历，判断每个情况下是否存在 O(n^3)
    * 对中间一个分割点遍历， 判断每个情况下是否存在 O(n^2)
    * .....
    
  以下的算法是对中间一个分割点遍历来实现的。

* 算法

     用separator表示三个下标 m1, m2, m3。firstSeparator 表示 m1， mid 表示 m2，lastSeparator 表示 m2。
     四个切片是 

     __[0,firstSeparator-1],[firstSeparator+1,mid-1]__,
     __[mid+1,lastSeparator-1],[lastSeparator+1,end]__
     
     所以，假设存在四个切片和相等的情况：
     前面两个切片，也就是__[0,firstSeparator-1],[firstSeparator+1,mid-1]__
     
     满足    __SS[mid-1] - SS[firstSeparator] = SS[firstSeparator-1] - SS[0]__
     ====>   __SS[mid-1] = SS[firstSeparator-1] + SS[firstSeparator]__
     
     后面两个切片，也就是__[mid+1,lastSeparator-1],[lastSeparator+1,end]__：
     
     满足    __sum - SS[lastSeparator] = SS[lastSeparator-1] - SS[mid]__
     ====>   __sum + SS[mid]  = SS[lastSeparator-1] + SS[lastSeparator]__
     
     这里拿到了**两个等式**：
       ___SS[mid-1] = SS[firstSeparator-1] + SS[firstSeparator]___
       ___sum + SS[mid]  = SS[lastSeparator-1] + SS[lastSeparator]___
     
     注意这里**右边的格式**其实是一致的，
     这两个等式要利用起来的话，也不难：
     首先在我们对mid的遍历过程中（也就是for(mid=1.....end)）,mid在每个情况下都是可知的，
     要想利用上面两个等式，就得利用**mid获取firstSeparator或者lastSeparator**，
     统言之**separator**.
     
     * 如何根据mid获取separator?那就是**map**.
     初始化的时候将所有可能的**(SS[separator]+SS[separator-1]，separator)**keyvalue对存入map,
     然后再遍历时候利用mid获取 **SS[mid-1]/sum + SS[mid]**，
     这里等于SS**[separator]+SS[separator-1]**的值,利用这个值就可以获取这个separator了！
     链接：<a href="https://www.nowcoder.com/discuss/21321?type=0&order=0&pos=7&page=1">https://www.nowcoder.com/discuss/21321?type=0&order=0&pos=7&page=1</a>
     来源：牛客网
     

    
    
* show the code
    
```java
package personal.darxan.hostel.jmx.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * Created by darxan on 2017/3/3. 
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
        for (Integer firstSlice: firstSliceList) { //以下代码只会执行N次
            if (firstSlice>=mid) continue;
            BigInteger leftPartSum = SS[mid-1].subtract(SS[firstSlice]);
            leftPartSet.add(leftPartSum);
        }
        for (Integer lastSlice: lastSliceList) {  //以下代码只会执行N次
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

```

* 目前并不保证O(n)计算复杂度，因为map操作不一定是O(1)
  才疏学浅，如果有所疏漏还望批评指教， 381675152@qq.com