package com.example.backdemo.demo.aspect;

import com.example.backdemo.common.annotation.TestAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: superman
 * @create: 2020-06-10 16:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAspectJAutoProxy
@Slf4j
public class Demo {

    @Test
    public void  test1(){
        test2();
//        System.out.println("aspect demo1");
    }
    @TestAnnotation(beforeCheck = true)
    public void test2() {
        System.out.println("aspect demo2");
    }
}
