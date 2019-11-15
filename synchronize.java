**
 * @Author: BaiMiao
 * @Date: 2019/11/14 18:29
 * @Description:
 */
//一把锁保护一个相应资源，不同锁保护不同资源
    /*
    * Java中锁的实现：
    * 使用synchronize关键字为程序逻辑上锁
    * 1.同步代码块
    * synchronize（锁的对象|Object及其子类|类对象）{
    *   //此处代码块在任意时刻只能有一个线程进入
    * }
    * 2.同步方法
    * 直接在方法声明上使用synchronize，
    * 此时表示同步方法在任意时刻只能有一个线程进入
    * */
/*
class TicketTask implements Runnable{
    private int ticket=10;
    @Override
    */
/*
    * 还剩1票  线程1
    * 还剩0票  线程2
    * 还剩-1票  线程3
    * *//*

    public void run() {
        //ticket=1；
        //条件处只能在某一时刻只有一个线程，需要为程序段上锁
        while (this.ticket>0){
            //线程1 2 3
            try{
                //线程2
                //线程3
                //线程1
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //线程1 ticket=0；
            //线程2 ticket=-1；
            //线程3 ticket=-2；
            System.out.println("还剩下"+ticket--+"票");
        }
    }
}
public class SellTicket {
    public static void main(String[] args) {
        TicketTask ticketTask=new TicketTask();
        Thread thread1=new Thread(ticketTask,"A");
        Thread thread2=new Thread(ticketTask,"B");
        Thread thread3=new Thread(ticketTask,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
*/
/*class TaskTicket implements Runnable{
    private int ticket=20000;
    @Override
    public void run() {
     for (int i=0;i<20000;i++){
         //在判断处上锁 保证只有一个线程能进入条件判断
         synchronized (this) { //为当前对象TaskTicket上锁
             if (ticket > 0) {
                 try {
                     Thread.sleep(20);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+
                         "还剩" + ticket-- + "票");
             }
         }
     }
        }
    }*/
public class SellTicket{
    public static void main(String[] args) {
        TaskTicket ticketTask=new TaskTicket();
        Thread thread1=new Thread(ticketTask,"A");
        Thread thread2=new Thread(ticketTask,"B");
        Thread thread3=new Thread(ticketTask,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class TaskTicket implements Runnable{
    private int ticket=200;

    @Override
    public void run() {
        for (int i=0;i<200;i++){
            sellticket();
        }
    }
    public synchronized void sellticket() { //默认锁的是this（当前对象）
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() +
                    "还剩下" + ticket-- + "票");
        }
    }
}
