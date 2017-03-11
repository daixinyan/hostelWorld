package personal.darxan.hostel.jmx.lock;

/**
 * Created by darxan on 2017/3/3.
 */
import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在这个例子中消费take()需要 队列不为空，
 * 如果为空就挂起（await()），
 * 直到收到notEmpty的信号；
 * 生产put()需要队列不满，如果满了就挂起（await()），直
 * 到收到notFull的信号
 *
 * 可能有人会问题，如果一个线程lock()对象后被挂起
 * 还没有unlock，那么另外一个线程就拿不到锁了
 * （lock()操作会挂起），那么就无法通知(notify)前一个线程，这样岂不是“死锁”了？
 * @param <T>
 */
public class ProductQueue<T> {

    private final T[] items;

    private final Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    //
    private int head, tail, count;

    public ProductQueue(int maxSize) {
        items = (T[]) new Object[maxSize];

    }

    public ProductQueue() {
        this(10);
    }

    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == getCapacity()) {
                notFull.await();
            }
            items[tail] = t;
            if (++tail == getCapacity()) {
                tail = 0;
            }
            ++count;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T ret = items[head];
            items[head] = null;//GC
            //
            if (++head == getCapacity()) {
                head = 0;
            }
            --count;
            notFull.signalAll();
            return ret;
        } finally {
            lock.unlock();
        }
    }

    public int getCapacity() {
        return items.length;
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

}