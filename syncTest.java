/**
 * @Author: BaiMiao
 * @Date: 2019/11/15 17:44
 * @Description:
 * synchronize对象锁
 * *锁的是哪个对象，保护的是哪个资源*
 * 若synchronize修饰的是静态方法或synchronize(类名称.class)
 * 锁的都是当前类的反射对象(全局唯一)
 */
class sync{
    public synchronized void test() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+"执行开始...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"执行结束...");
    }
}
class Task implements Runnable{
    //sync sync=new sync(); 锁的是一个对象 1 开始；1结束；....
    //三个线程共享一个sync对象 可以锁住
    @Override
    public void run() {
        sync sync=new sync();//1 0 2 开始 ；1 0 2 结束；
        try {
            sync.test();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class SyncTest {
    public static void main(String[] args) {
        Task task=new Task();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
