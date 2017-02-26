package personal.darxan.hostel.jmx;

/**
 * Created by darxan on 2017/2/12.
 * 1、其中第13行是通过工厂类获取MBeanServer，用来做MBean的容器 。
 * 2、第14行中的ObjectName中的取名是有一定规范的，
 *  格式为：“域名：name=MBean名称”，其中域名和MBean的名称可以任意取。
 *  这样定义后，就可以唯一标识我们定义的这个MBean的实现类了。
 * 3、第16行是将Hello这个类注入到MBeanServer中，注入需要创建一个ObjectName类
 *
 * 这样，一个简单的JMX的DEMO已经写完了，现在我们通过JDK提供的Jconsole来进行操作。
 */
import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class HelloAgent
{
    public static void main(String[] args) throws JMException, Exception
    {
        jdmk();
    }

    public static void jdmk() throws JMException, Exception
    {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);
        try
        {
            //这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
            LocateRegistry.createRegistry(9999);
            //URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
            JMXServiceURL url = new JMXServiceURL
                    ("impl:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
            System.out.println("begin rmi start");
            jcs.start();
            System.out.println("rmi start");
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void console() throws JMException, Exception
    {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("fieldsName:name=MBeanName");
        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60*60*1000);
    }
}