package personal.darxan.hostel.jmx.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.darxan.hostel.controller.PublicController;
import personal.darxan.hostel.vo.LoginVO;

/**
 * Created by darxan on 2017/3/6.
 */
public class Main
{

    public static void exe(ApplicationContext ctx) {
        PublicController publicController = ctx.getBean(PublicController.class);
        LoginVO loginVO = new LoginVO();
        loginVO.setLoginType("user");
        loginVO.setName("darxan");
        loginVO.setPassword("darxan");
        publicController.loginAction(null, loginVO);
    }

    public static void main(String[] args)
    {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");


//        HelloWorld hw1 = (HelloWorld)ctx.getBean("helloWorldImpl1");
//        HelloWorld hw2 = (HelloWorld)ctx.getBean("helloWorldImpl2");
//        hw1.printHelloWorld();
//        System.out.println();
//        hw1.doPrint();
//
//        System.out.println();
//        hw2.printHelloWorld();
//        System.out.println();
//        hw2.doPrint();

        exe(ctx);
    }
}
