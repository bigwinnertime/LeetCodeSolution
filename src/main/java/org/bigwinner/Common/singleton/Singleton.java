package org.bigwinner.Common.singleton;

/**
 * @author: IT大狮兄
 * @date: 2022/1/8 下午12:45
 * @version: 1.0.0
 * @description: 面试手撕单例设计模式
 */
public class Singleton extends Thread {
    public static void main(String[] args) {
        long start = System.nanoTime();
        Singleton[] mts = new Singleton[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new Singleton();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
        long end = System.nanoTime();
        System.out.println("time used: " + (end - start));
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(EagerSingleton.getEagerSingleton().hashCode());
//        System.out.println(LazySingleton.getLazySingleton().hashCode());
//        System.out.println(ThreadSafeLazySingleton.getInstance().hashCode());
//        System.out.println(DoubleCheckSingleton.getDoubleCheckSingleton().hashCode());
        System.out.println(InternalLoadSingleton.getInstance().hashCode());
    }
}

/**
 * 饿汉式
 * 缺点：对象未被使用时，就已经被实例化加载到JVM，造成资源浪费
 */
class EagerSingleton {
    private static EagerSingleton eagerSingleton = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }
}

/**
 * 懒汉式
 * 缺点：线程不安全
 */
class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton() {}
    public static LazySingleton getLazySingleton() {
        if (null == lazySingleton) lazySingleton = new LazySingleton();
        return lazySingleton;
    }
}

/**
 * 线程安全的懒汉式
 * 缺点：多线程并发效率低
 */
class ThreadSafeLazySingleton{
    private static ThreadSafeLazySingleton threadSafeLazySingleton = null;
    private ThreadSafeLazySingleton() {}
    public static synchronized ThreadSafeLazySingleton getInstance() {
        if (null == threadSafeLazySingleton) threadSafeLazySingleton = new ThreadSafeLazySingleton();
        return threadSafeLazySingleton;
    }
}

/**
 * 双重检查锁（并发+安全）
 * 缺点：如果new的过程耗时，多线程访问时会获取到没有初始化全的对象。
 */
class DoubleCheckSingleton{
    private static DoubleCheckSingleton doubleCheckSingleton = null;
    private DoubleCheckSingleton() {}
    public static DoubleCheckSingleton getDoubleCheckSingleton() {
        // 第一重检查
        if (null == doubleCheckSingleton) {
            synchronized (DoubleCheckSingleton.class) {
                // 第二重检查
                if (null == doubleCheckSingleton) doubleCheckSingleton = new DoubleCheckSingleton();
            }
        }
        return doubleCheckSingleton;
    }
}

/**
 * 使用静态内部类实现懒加载，使用
 */
class InternalLoadSingleton{
    private static class SingletonHelper{
        private static InternalLoadSingleton internalLoadSingleton = new InternalLoadSingleton();
    }
    public static InternalLoadSingleton getInstance() {
        return SingletonHelper.internalLoadSingleton;
    }
}

