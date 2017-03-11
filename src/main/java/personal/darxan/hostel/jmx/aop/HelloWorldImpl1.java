package personal.darxan.hostel.jmx.aop;

import org.springframework.stereotype.Component;

/**
 * Created by darxan on 2017/3/6.
 */
@Component
public class HelloWorldImpl1 implements HelloWorld
{
    public void printHelloWorld()
    {
        System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
    }

    public void doPrint()
    {
        System.out.println("Enter HelloWorldImpl1.doPrint()");
//        new Exception().printStackTrace();
        return ;
    }
}