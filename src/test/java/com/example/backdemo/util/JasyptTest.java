package com.example.backdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: superman
 * @create: 2020-06-05 11:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JasyptTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encrypt() {
        String encrypt = stringEncryptor.encrypt("root");
        String encrypt1 = stringEncryptor.encrypt("123456");
        String encrypt2 = stringEncryptor.encrypt("3306");
        String encrypt3 = stringEncryptor.encrypt("6379");
        String encrypt4 = stringEncryptor.encrypt("127.0.0.1");
        System.out.println(encrypt);
        System.out.println(encrypt1);
        System.out.println(encrypt2);
        System.out.println(encrypt3);
        System.out.println(encrypt4);
    }

    public static void main(String[] args) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
//        encryptor.setPassword("opera_123");
//        System.out.println(encryptor.encrypt("Zyy_219184"));
//        System.out.println(encryptor.encrypt("yaoyaoz@opera.com"));

        encryptor.setPassword("wyfdc_888");
        System.out.println(encryptor.encrypt("127.0.0.1"));
        System.out.println(encryptor.encrypt("root"));
        System.out.println(encryptor.encrypt("3306"));
        System.out.println(encryptor.encrypt("6379"));
    }
}
