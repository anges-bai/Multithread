import java.util.concurrent.*;

/**
 * @Author: BaiMiao
 * @Date: 2020/1/4 17:22
 * @Description:
 */

class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
        return Thread.currentThread().getName() + "任务执行完毕";
    }
}

public class test2 {
    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(3, 5,
                2000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            Future<String> future = threadPoolExecutor.submit(callableThread);
            try {
                String str = future.get();
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

