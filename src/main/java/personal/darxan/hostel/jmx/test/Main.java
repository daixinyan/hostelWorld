package personal.darxan.hostel.jmx.test;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by darxan on 2017/3/5.
 */
public class Main {

    static void println(Object o) {
//        System.out.println(o);
    }

    static int[] isValid(String line) {
        String[] array = line.split("\\.");
        int[] result = new int[4];
        if (array.length==4) {
            for (int i=0; i<4; i++) {

                int intValue = Integer.parseInt(array[i]);
                if (intValue<=255) {
                    result[i] = intValue;
                }else {
                    return null;
                }
            }
            return result;
        }
        return null;
    }

    static int getType(int value) {
        if (value>=240)
            return 5;
        if (value>=224)
            return 4;
        if (value>=192) {
            return 3;
        }
        if (value>=127)
            return 2;

        return 1;
    }

    static void read() {
        Scanner scanner = new Scanner(System.in);

        IPObject[] ipArray = new IPObject[5];
        for (int i=0; i<5; i++) {
            String line = scanner.nextLine();
            ipArray[i] = new IPObject(line);
        }



        //sort
        for (int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {
                if (ipArray[i].compare(ipArray[j])>0) {
                    IPObject temp = ipArray[i];
                    ipArray[i] = ipArray[j];
                    ipArray[j] = temp;

                }
            }
        }

        for (IPObject ip:ipArray) {
            println(ip);
        }

        //print
        StringBuilder showString = new StringBuilder("");

        String printType[] = {"", "A", "B", "C", "D", "E"};
        for (int type=1; type<=5; type++) {
            for (int i=0; i<5; i++) {
                if (!ipArray[i].valid) {
                    continue;
                }
                if (ipArray[i].type==type) {
                   showString.append(ipArray[i].line);
                   showString.append(",");
                }
            }
            if (showString.length()!=0) {
                System.out.print(printType[type]+":[");
                System.out.print(showString.subSequence(0, showString.length()-1).toString());
                System.out.println("]");

                showString = new StringBuilder("");
            }
        }
    }

    static class IPObject{

        String line;

        int[] ips;


        int type;

        boolean valid;

        int compare(IPObject other) {
            for (int i=0; i<4; i++) {
                if (other.ips[i]>ips[i]) {
                    return -1;
                }
                if (other.ips[i]<ips[i]) {
                    return 1;
                }
            }
            return 0;
        }
        /*
80.1.1.1
90.1.1.1
180.1.1.1
190.1.1.1
200.1.1.1
        */
        IPObject(String line) {
            this.line = line;
            ips = isValid(line);
            valid = true;
            if (ips==null) {
                valid = false;

                type = 0;
            }else {
                valid = true;
                type = getType(ips[0]);
            }
        }

    }

    public static void main(String[] args) {
        read();
    }
}
