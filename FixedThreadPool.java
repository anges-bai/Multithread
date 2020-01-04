import java.util.concurrent.*;

/**
 * @Author: BaiMiao
 * @Date: 2020/1/4 17:26
 * @Description:
 */

public class test3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.
                newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().
                                getName() + "、" + j);
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
