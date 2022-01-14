package org.bigwinner.Common;

import java.util.concurrent.TimeUnit;

/**
 * @author: IT大狮兄
 * @date: 2022/1/14 上午8:42
 * @version: 1.0.0
 * @description: 类锁与方法锁
 */
public class Synchronized {
    public static synchronized void classSyn1() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******类锁1111开始******");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + ":******类锁1111结束******");
    }
    public static synchronized void classSyn2() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******类锁2222开始******");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + ":******类锁2222结束******");
    }
    public synchronized void methodSyn1() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******对象锁aaaaa开始******");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + ":******对象锁aaaaa结束******");
    }

    public synchronized void methodSyn2() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******对象锁bbbbb开始******");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + ":******对象锁bbbbb结束******");
    }

    public static void main(String[] args) throws Exception {
        /**
         * 输出结果：
         * 对象锁11111:******对象锁aaaaa开始******
         * 对象锁22222:******对象锁aaaaa开始******
         * 对象锁22222:******对象锁aaaaa结束******
         * 对象锁11111:******对象锁aaaaa结束******
         * 对象锁33333:******对象锁bbbbb开始******
         * 对象锁33333:******对象锁bbbbb结束******
         */
        Synchronized sy1 = new Synchronized();
        new Thread(()->{
            try {
                sy1.methodSyn1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"对象锁11111").start();
        new Thread(()->{
            try {
                sy1.methodSyn2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"对象锁33333").start();

        Synchronized sy2 = new Synchronized();
        new Thread(()->{
            try {
                sy2.methodSyn1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"对象锁22222").start();

        System.out.println("----------------------分割线----------------------");

        /**
         * 输出结果：
         * 类锁aaaaa:******类锁1111开始******
         * 方法锁bbbbb:******对象锁aaaaa开始******
         * 类锁aaaaa:******类锁1111结束******
         * 类锁ccccc:******类锁2222开始******
         * 类锁ccccc:******类锁2222结束******
         * 方法锁bbbbb:******对象锁aaaaa结束******
         */
        new Thread(()->{
            try {
                Synchronized.classSyn1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"类锁aaaaa").start();

        new Thread(()->{
            try {
                Synchronized.classSyn2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"类锁ccccc").start();

        new Thread(()->{
            try {
                sy1.methodSyn1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"方法锁bbbbb").start();

    }



}
