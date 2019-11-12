class MyThraed1 implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            //同一时刻，只允许一个线程进入代码块处理
            synchronized (this){//为程序上锁
                while(this.ticket>0){
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }//模拟网络延迟
                    System.out.println(Thread.currentThread().getName()
                            +"还有"+this.ticket--+"张票");
                }
            }

        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyThraed1 mt1=new MyThraed1();
        Thread thread1=new Thread(mt1,"黄牛A");
        Thread thread2=new Thread(mt1,"黄牛B");
        Thread thread3=new Thread(mt1,"黄牛C");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
