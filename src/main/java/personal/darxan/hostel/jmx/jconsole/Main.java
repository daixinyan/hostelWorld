package personal.darxan.hostel.jmx.jconsole;

import personal.darxan.hostel.tool.MyLogger;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by darxan on 2017/3/10.
 */
public class Main {

    public static void main(String args[]) {
        execute();
    }

    static void execute() {
        Thread count = new Thread(new Runnable() {
            public void run() {

                try {
                    while (true) {
                        MyLogger.log(cacheReferenceMap.size());
                        Thread.sleep(200);
                    }
                }catch (Exception e) {
                    MyLogger.log("out!!");
                    e.printStackTrace();
                }
            }
        });
        count.start();
        try {
            while (true) {
                addCache();
            }
        }catch (OutOfMemoryError outOfMemoryError) {
            count.interrupt();
            outOfMemoryError.printStackTrace();
        }
    }

    static final Map<Integer, Object> cacheReferenceMap
            = new HashMap<Integer, Object>();

    static Random random = new Random();

    static void addCache() {
        Cache cache = new Cache();
//        Reference<Cache> reference = new WeakReference<Cache>(cache);

        cacheReferenceMap.put(random.nextInt(), cache);
    }

    static class Cache {

        int[] list = new int[64];
    }
}
