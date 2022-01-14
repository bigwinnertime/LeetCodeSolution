package org.bigwinner.Common.jvm;

import sun.jvm.hotspot.HelloWorld;

/**
 * @author: bigwinner
 * @date: 2020/7/20 2:48 下午
 * @version: 1.0.0
 * @description: 测试JVM类的加载方式
 */
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
         * ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
         * Class.forName(name,initialize,loader)带参函数initialize也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。
         */
        ClassLoader loader = HelloWorld.class.getClassLoader();
        loader.loadClass("org.bigwinner.jvm.Test");  // 打印输出为空
        Class.forName("org.bigwinner.jvm.Test");  // 打印输出：执行静态代码块
        Class.forName("org.bigwinner.jvm.Test", false, loader);  // 打印输出为空å
    }
}

class Test{
    static {
        System.out.println("执行静态代码块");
    }
}

