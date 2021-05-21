package org.bigwinner.leetcode.Simple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: bigwinner
 * @date: 2021/2/14 下午10:07
 * @version: 1.0.0
 * @description: 顺序打印
 */
public class OrderPrint_1114 {

    /** 借助全局原子性计数器，根据计数器的值决策是否执行下一个线程 **/
    private AtomicInteger firstCounter = new AtomicInteger(0);
    private AtomicInteger secondCounter = new AtomicInteger(0);
    public OrderPrint_1114() {

    }

    /**
     * 我们提供了一个类：
     *
     * public class Foo {
     *   public void first() { print("first"); }
     *   public void second() { print("second"); }
     *   public void third() { print("third"); }
     * }
     * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
     *
     * 一个将会调用 first() 方法
     * 一个将会调用 second() 方法
     * 还有一个将会调用 third() 方法
     * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: "firstsecondthird"
     * 解释:
     * 有三个线程会被异步启动。
     * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
     * 正确的输出是 "firstsecondthird"。
     * 示例 2:
     *
     * 输入: [1,3,2]
     * 输出: "firstsecondthird"
     * 解释:
     * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
     * 正确的输出是 "firstsecondthird"。
     */
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstCounter.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstCounter.get() != 1) {}

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondCounter.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondCounter.get() != 1) {}

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
class OrderPrint_11142 {
    /** 同步原语 **/
    private volatile int flag = 1;
    private final Object object = new Object();

    public OrderPrint_11142() {

    }
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) object.wait();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) object.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) object.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
