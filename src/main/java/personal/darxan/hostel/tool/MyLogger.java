package personal.darxan.hostel.tool;

/**
 * Created by darxan on 2017/2/16.
 */
public final class MyLogger {



    public static final void log(Object object) {
        println(object);
    }

    public static final void print(Object object) {
        System.out.print(object.toString());
    }

    public static final void println(Object object) {
        System.out.println(object.toString());
    }
}
