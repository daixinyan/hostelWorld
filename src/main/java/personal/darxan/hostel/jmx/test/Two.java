package personal.darxan.hostel.jmx.test;

import java.util.Scanner;

/**
 * Created by darxan on 2017/3/10.
 */
public class Two {

    static void println(Object o) {
//        System.out.println(o);
    }

    static void read() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(
                solve(line)?"yes":"no");
    }

    static boolean solve(String line) {

        for (int i=0; i<line.length()-1; i+=1) {
            if (line.charAt(i)==line.charAt(i+1)) {
                try {
                    if (isFormatThree(line.substring(0,i)+line.substring(i+2))){
                        return true;
                    }
                }
                catch (Exception e) {
                }

            }
        }
        return false;

    }

    static boolean isFormatThree(String line) {

        println("format three");
        println(line);
        int length = line.length();
        if (length==0) {
            println("length=0");
            return true;
        }
        if (length%3!=0 || length<3) {
            println("wrong length");
            return false;
        }

        if (line.charAt(0)==line.charAt(1)  ) {
            if (line.charAt(0)==line.charAt(2)) {
                return isFormatThree(line.substring(3));
            }
            if (line.charAt(0)==line.charAt(2)-1) {
                for (int i=3; true; i++) {
                    if (line.charAt(i)==line.charAt(2)) {
                        continue;
                    }
                    if (line.charAt(0)==line.charAt(i)-2) {
                        return isFormatThree(
                                line.charAt(1)+line.substring(3,i)+line.substring(i+1)
                        );
                    }
                    return false;
                }
            }
        }else if (line.charAt(0)==line.charAt(1)-1){
            for (int i=2; true; i++) {
                if (line.charAt(i)==line.charAt(1)) {
                    continue;
                }
                if (line.charAt(0)==line.charAt(i)-2) {
                    return isFormatThree(line.substring(2,i)+line.substring(i+1));
                }
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        read();
    }
}
