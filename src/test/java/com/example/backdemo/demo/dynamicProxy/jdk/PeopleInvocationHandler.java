package com.example.backdemo.demo.dynamicProxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: superman
 * @create: 2020-06-05 14:49
 **/
public class PeopleInvocationHandler implements InvocationHandler {

    private People people;

    public PeopleInvocationHandler(People people) {
        this.people = people;
    }

    private void begin() {
        System.out.println("方法开始执行");
    }

    private void end() {
        System.out.println("方法执行完毕");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        begin();
        method.invoke(people, args);
        end();
        return null;
    }

    public static void main(String[] args) throws Exception{
        People people = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new PeopleInvocationHandler(new Chinese()));
        people.sayHello();

        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{People.class});
        FileOutputStream os = new FileOutputStream("/Users/zhuyaoyao/Downloads/$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
