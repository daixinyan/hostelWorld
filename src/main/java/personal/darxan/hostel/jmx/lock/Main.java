package personal.darxan.hostel.jmx.lock;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by darxan on 2017/3/3.
 */
public class Main
{
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            public void run() {
                execute(1);
            }

            private void execute(int i) {
                if(i<8)
                try{
                    try{
                        execute(i+1);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    throw new Exception("did you every checked that?: check at: "+new Random().nextInt(100));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
//        t.interrupt();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        ConcurrentHashMap concurrentHashMap ;
        /**
         * 读写锁允许读线程和写线程按照请求锁的顺序重新获取读取锁或者写入锁。
         * 当然了只有写线程释放了锁，读线程才能获取重入锁。
         * 写线程获取写入锁后可以再次获取读取锁，但是读线程获取读取锁后却不能获取写入锁。
         * 另外读写锁最多支持65535个递归写入锁和65535个递归读取锁。
         */
        readWriteLock.readLock().lock();
        readWriteLock.writeLock().lock();

        ReentrantLock reentrantLock = new ReentrantLock();


        ConcurrentMap concurrentMap = new ConcurrentHashMap();
        HashMap hashMap;

        ExecutorService executorService =
                Executors.newFixedThreadPool(2);

        Future future = executorService.submit((Runnable)null);
        ThreadPoolExecutor threadPoolExecutor;

        Callable callable;
        Executor executor;
        Executors executors;

    }

    private static void readFileNIO() {
        String file = "";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(64);

            int read;
            while (( read = fileChannel.read(byteBuffer))!=-1) {
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.println(byteBuffer.get());
                }
            }

            byteBuffer.clear();
            byteBuffer.compact();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void select() {
        try {
            Selector selector = Selector.open();
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void netty() {

    }
}
