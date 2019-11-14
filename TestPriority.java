/**
 * @Author: BaiMiao
 * @Date: 2019/11/14 17:36
 * @Description:线程优先级
 * 1.设置优先级setPriority(int priority);
 * 2.取得优先级int getPriority();
 */
class PriThread implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+"i="+i);
        }
    }
}
public class TestPriority {
    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getPriority());
        PriThread priThread=new PriThread();
        Thread thread1=new Thread(priThread);
        Thread thread2=new Thread(priThread);
        Thread thread3=new Thread(priThread);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
