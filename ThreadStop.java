/**
 * @Author: BaiMiao
 * @Date: 2019/11/14 15:12
 * @Description:线程停止
 * 1.设置标记位(无法处理线程阻塞时停止的问题)
 * 2.stop（）；方法 Thread类提供。（强制退出，会产生不完整数据）不推荐使用
 * 3.通过调用Thread类提供的interrupt()；
 * a.若线程中没有使用类似sleep/wait/join（线程阻塞）调用interrupt方法并不会真正中断线程，
 *   只是将线程的状态知为interrupt，根据状态来确定进一步如何处理线程
 *   Thread类提供的 public boolean isInterrupted()可以检测当前线程是否为中断状态
 *b.若线程中调用了阻塞线程的方法如:sleep()，wait()，join()，
 *  此时调用线程的interrupt方法时会抛出异常InterruptedException
 *  同时将线程状态还原（isTnterrupted=false）
 */
class ThreadShutDown implements Runnable{
    private boolean flag=true;
    public void setFlag(boolean flag){
        this.flag=flag;
    }
    @Override
    public void run() {
        int i=0;
        while (flag){
            try{
                Thread.sleep(200);
                boolean bool=Thread.currentThread().isInterrupted();
                if (bool){
                    System.out.println("线程被置为中断状态");
                    return;
                }
                System.out.println("当前线程状态为"+bool);
                System.out.println(Thread.currentThread().getName()+","+i++);
            }catch (InterruptedException e){
                System.out.println("抛出中断异常");
                return;
               // e.printStackTrace();
            }

        }
        System.out.println("线程停止");
    }
}
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException{
        ThreadShutDown threadShutDown=new ThreadShutDown();
        Thread thread=new Thread(threadShutDown);
        thread.start();
        Thread.sleep(1000);
        //threadShutDown.setFlag(false);
        //thread.stop();
        thread.interrupt();
    }
}
