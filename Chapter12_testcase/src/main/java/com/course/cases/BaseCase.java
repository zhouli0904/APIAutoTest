package com.course.cases;

import com.course.MyApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@SpringBootTest(classes = MyApplication.class)
public abstract class BaseCase extends AbstractTestNGSpringContextTests {

}
