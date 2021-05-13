package com.course.testng.factory;

import org.testng.annotations.Factory;

/**
 * 如果不使用@Factory，运行普通的被@Test标注的方法时，实际上是TestNG框架调用了该类的构造函数构造出一个对象，然后再执行对象的这个方法。
 * 使用了@Factory后，可以看到被@Factory标注的方法返回了一个Object数组，数组中每一个元素是一个被测试类的对象。
 * 也就是说@Factory构造了多个被测试类对象，然后把每一个对象都传递给了TestNG框架，然后TestNG框架在分别执行这些对象中被@Test标注的方法。
 */

public class SimpleTestFactory {

    @Factory
    public Object[] factoryMethod() {
        SimpleTest test1 = new SimpleTest();
        SimpleTest test2 = new SimpleTest();
        return new Object[] { test1, test2 };
    }
}
