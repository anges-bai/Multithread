package bit.test;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = 
                Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().
                                getName() + "、" + j);
                    }
                }
            }, 2, 3, TimeUnit.SECONDS);
        }
    }
}
