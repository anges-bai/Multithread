/**
 * @Author: BaiMiao
 * @Date: 2019/11/19 20:39
 * @Description:
 * ThreadLocal---线程本地变量（属于线程私有资源，不与其他变量共享）
 * set（）设置线程私有属性值
 * get（）取得......
 */
public class Thread_localTest {
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<String>();

    public static void main(String[] args) {
        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);
        System.out.println(threadStr.get());
    }

}
