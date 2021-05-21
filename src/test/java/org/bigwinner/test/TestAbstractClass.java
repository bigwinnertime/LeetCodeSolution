package org.bigwinner.test;

/**
 * @author: bigwinner
 * @date: 2021/1/23 9:25 上午
 * @version: 1.0.0
 * @description: 测试抽象类
 */

/**
 * 抽象类中至少有一个抽象方法，否则定义抽象类毫无意义；
 * 抽象类的抽象方法不能有方法体，但是非抽象方法无限制；
 * 抽象类不能被实例化，只能通过子类实现具体的方法功能；
 * 非抽象类子类必须要实现父类的所有抽象方法(注意是抽象方法，非抽象方法可以不实现)；
 * 抽象类子类不需要实现父类的抽象方法；
 * 一个类只能继承一个抽象类(单继承)；
 */
public abstract class TestAbstractClass {
    // 成员变量
    private String string = "Abstract Test....";
    private static final Integer num = 10;
    String str = "default string test....";
    int number = 20;
    // 成员方法
    abstract void MemberMethodOne();
    abstract int MemberMethodTwo();
    void MemberMethodThree() {
        System.out.println("test MemberMethodThree");
    }
}

/**
 * 非抽象类子类必须要实现所有的父类抽象方法
 */
class TestAbstract1 extends TestAbstractClass{

    @Override
    void MemberMethodOne() {
        System.out.println("test TestAbstract1's MemberMethodOne.....");
    }

    @Override
    int MemberMethodTwo() {
        int num = 130;
        System.out.println("test TestAbstract1's MemberMethodTwo.....");
        return num;
    }
}
/**
 * 抽象类子类不需要实现父类的抽象方法
 */
abstract class TestAbstract2 extends TestAbstractClass{

}

class TestAbstract3 extends TestAbstractClass{

    @Override
    void MemberMethodOne() {
        System.out.println("test TestAbstract3's MemberMethodOne.....");
    }

    @Override
    int MemberMethodTwo() {
        int num = 120;
        System.out.println("test TestAbstract3's MemberMethodTwo.....");
        return num;
    }
}

class AbstractDemo {
    public static void main(String[] args) {
        // 测试抽象类子类1
        TestAbstractClass abstractClass = new TestAbstract1();
        abstractClass.MemberMethodOne();
        abstractClass.MemberMethodTwo();
        abstractClass.MemberMethodThree();

        System.out.println("---------------分割线---------------");

        // 测试抽象类子类2
        TestAbstractClass testAbstractClass = new TestAbstract3();
        testAbstractClass.MemberMethodOne();
        testAbstractClass.MemberMethodTwo();
        testAbstractClass.MemberMethodThree();

    }
}
