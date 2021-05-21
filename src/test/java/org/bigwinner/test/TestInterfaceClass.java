package org.bigwinner.test;

/**
 * @author: bigwinner
 * @date: 2021/1/23 9:26 上午
 * @version: 1.0.0
 * @description: 测试接口类
 */

/**
 * 在 Java 中是一个抽象类型，是抽象方法的集合，即接口类中的方法只能是抽象方法，同样抽象方法不能有方法体；
 * 接口中的成员变量隐式为 static final，即接口类的成员变量都是常量；
 * 一个类可以实现多个接口(多实现)；
 * 接口不能被实例化，只能通过子类实现具体的方法功能；
 */
public interface TestInterfaceClass {
    String string = "test TestInterfaceClass...";
    // 隐式的public和abstract
    public abstract void testMemberMethod1();
    public abstract int testMemberMethod2();

}
interface TestInterFaceClass1 {
    void testMemberMethod3();
    int testMemberMethod4();
}

class Class1 implements TestInterfaceClass {

    @Override
    public void testMemberMethod1() {
        System.out.println("防守");
    }

    @Override
    public int testMemberMethod2() {
        System.out.println("test TestInterfaceClass's testMemberMethod1.....");
        return 0;
    }
}

class Class2 implements TestInterfaceClass {

    @Override
    public void testMemberMethod1() {
        System.out.println("进攻");
    }

    @Override
    public int testMemberMethod2() {
        System.out.println("test TestInterfaceClass's testMemberMethod1.....");
        return 0;
    }
}

class Class3 implements TestInterfaceClass, TestInterFaceClass1 {
    @Override
    public void testMemberMethod1() {
        System.out.println("test TestInterfaceClass's testMemberMethod1.....");
    }

    @Override
    public int testMemberMethod2() {
        System.out.println("test TestInterfaceClass's testMemberMethod2.....");
        return 0;
    }

    @Override
    public void testMemberMethod3() {
        System.out.println("test TestInterFaceClass1's testMemberMethod3.....");
    }

    @Override
    public int testMemberMethod4() {
        System.out.println("test TestInterFaceClass1's testMemberMethod4.....");
        return 0;
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
        TestInterfaceClass interfaceClass = new Class1();
        interfaceClass.testMemberMethod1();
        interfaceClass.testMemberMethod2();

    }
}

class InterfaceDemo2 {
    public static void testInterfaceMethod1(TestInterfaceClass test1) {
        test1.testMemberMethod1();
    }
    public static int testInterfaceMethod2(TestInterFaceClass1 test2) {
        return test2.testMemberMethod4();
    }
    public static void main(String[] args) {
        Class3 class3 = new Class3();
        testInterfaceMethod1(class3);
        testInterfaceMethod2(class3);

    }
}

/**
 * 策略模式
 */
class InterfaceDemo3 {
    public static void strateges(TestInterfaceClass test) {
        test.testMemberMethod1();
    }
    public static void main(String[] args) {
        strateges(new Class1());
        strateges(new Class2());

    }
}

/**
 * 适配器模式
 */
abstract class TestAdapter implements TestInterfaceClass{
    public void testMemberMethod1() {
    }
    public int testMemberMethod2() {
        return 0;
    }
}

class AdapterTest extends TestAdapter {
    public void testMemberMethod1() {
        System.out.println("防守兼进攻。。。");
    }
}

class InterfaceDemo4 {
    public static void main(String[] args) {
        TestInterfaceClass interfaceClassDemo = new AdapterTest();
        interfaceClassDemo.testMemberMethod1();
    }

}


