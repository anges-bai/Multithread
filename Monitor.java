/**
 * @Author: BaiMiao
 * @Date: 2019/11/19 18:24
 * @Description:
 * synchronize底层实现：
 * 在使用synchronize时必须保证锁定对象为Object及其子类对象
 * synchronize使用的是JVM层级别的MonitorEnter与MonitorExit实现
 * 这两个指令都必须获取对象的同步监视器Monitor-对象锁机制
 * MonitorEnter
 * 检查O对象的Monitor计数器值是否为0，为0表示此监视器还未被任意一个线程获取，
 * 此时线程可以进入同步代码块并且将Monitor值+1，将Monitor的持有线程标记为当前线程
 *    当Monitor计数器值不为0且持有线程不是当前线程，
 * 表示Monitor已经被别的线程占用，当前线程只能阻塞等待（等待Monitor为0）
 *    当Monitor计数器值不为0但是持有线程恰好是当前线程（可重入锁）
 * MonitorExit-线程释放
 * Monitor计数器值-1
 *
 * 可重入锁
 * 当执行MonitorExit时。对象的Monitor计数器值不为0，但是持有线程恰好是当前线程
 * 此时将Monitor计数器值再次+1，当前线程继续进入同步方法或代码块
 */
