class MyThread  implements Runnable{
    private int ticket=10;
    private String title;
    public MyThread(String title){
        this.title=title;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            ticket--;
            System.out.println(this.title+" "+i+"票");
        }
    }
}
public class Test1{
    public static void main(String[] args) {
        MyThread myThread1=new MyThread("thraed1");
        MyThread myThread2=new MyThread("thread2");
        MyThread myThread3=new MyThread("thraed3");
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();
        //Thread类提供的构造方法  public Thread(Runnable target)
        //多线程只能由start（）开始
    }
}
