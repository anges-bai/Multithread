/**
 * @Author: BaiMiao
 * @Date: 2019/11/25 21:10
 * @Description:
 * wait，notify必须使用在synchronized同步方法或者代码块内。
 *   notify方法就是使停止的线程继续运行。
 *  1. 方法notify()也要在同步方法或同步块中调用，该方法是用来通知那些可能等待该对象
 *     的对象锁的其它线程，对其发出通知notify，并使它们重新获取该对象的对象锁。
 *    如果有多个线程等待，则有线程规划器随机挑选出一个呈wait状态的线程。
 *  2. 在notify()方法后，当前线程不会马上释放该对象锁，
 *     要等到执行notify()方法的线程将程序执行完，也就是退出同步代码块之后才会释放对象锁。
 */
class MyThread implements Runnable {
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag, Object obj) {
        super();
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod() {
        synchronized (obj) {
            try {
                while (true) {
                    System.out.println("wait()方法开始.. "
                            + Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait()方法结束.. "
                            + Thread.currentThread().getName());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyMethod() {
        synchronized (obj) {
            try {
                System.out.println("notify()方法开始.. "
                        + Thread.currentThread().getName());
                obj.notify();
                System.out.println("notify()方法结束.. "
                        + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }
}

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread waitThread = new MyThread(true, object);
        MyThread notifyThread = new MyThread(false, object);
        Thread thread1 = new Thread(waitThread, "wait线程");
        Thread thread2 = new Thread(notifyThread, "notify线程");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        System.out.println("main方法结束!!");
    }
}
