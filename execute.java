import java.util.concurrent.*;

/**
 * @Author: BaiMiao
 * @Date: 2020/1/4 17:21
 * @Description:
 */

class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
    }
}

public class test1 {
    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(3, 5,
                2000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(runnableThread);
        }
    }
}


