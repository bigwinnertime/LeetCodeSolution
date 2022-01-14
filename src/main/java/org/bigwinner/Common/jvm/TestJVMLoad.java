package org.bigwinner.Common.jvm;

/**
 * @author: bigwinner
 * @date: 2020/7/20 11:41 上午
 * @version: 1.0.0
 * @description: 测试JVM类加载
 */
public class TestJVMLoad {
    // 考察JVM对类的使用
    public static void main(String[] args) {
        /**
         * 被动使用
         * 1、引用父类的静态字段，只会引起父类的初始化，而不会引起子类的初始化。
         * 2、引用类的常量，不会引起类的初始化，直接从常量池获取常量值。
         * 3、定义类数组，不会引起类的初始化。
         *
         */
        System.out.println(ChildClass.value);   // 打印结果： 父类的静态代码块被执行   10
        System.out.println(FatherClass.val);    // 打印结果： 100
        FatherClass[] fc = new FatherClass[10];  // 打印结果： 无输出
        /**
         * 主动使用
         * 通过new关键字实例化对象/读取或设置类的静态变量/调用类的静态方法 会触发类的初始化
         */
        FatherClass.print(); // 父类的静态代码块被执行  父类的静态方法被执行
        System.out.println(FatherClass.value);    // 打印结果： 父类的静态代码块被执行   10
    }
}

class FatherClass {
    public final static  int val = 100;
    public static int value = 10;
    static {
        System.out.println("父类的静态代码块被执行");
    }
    public static void print() {
        System.out.println("父类的静态方法被执行");
    }
}

class ChildClass extends FatherClass {
    static {
        System.out.println("子类的静态代码块被执行");
    }
}


