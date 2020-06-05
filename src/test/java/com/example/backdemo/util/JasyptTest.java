package com.example.backdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
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
        System.out.println(encrypt);
        System.out.println(encrypt1);
        System.out.println(encrypt2);
        System.out.println(encrypt3);
    }
}
