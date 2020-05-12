package com.example.backdemo.redission;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: superman
 * @create: 2020-05-06 14:34
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedissionClientTest {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void baseUse() {
//        reactiveRedisTemplate.opsForValue().set("test", "test");
//        redisTemplate.opsForValue().set("qwe","sadas");
        Stopwatch stopwatch = Stopwatch.createStarted();
        redisTemplate.opsForList().leftPush("list", "a");
        redisTemplate.opsForList().leftPush("list", "b");
        redisTemplate.opsForList().leftPush("list", "c");
        Object o = redisTemplate.opsForList().rightPop("list");
        System.out.println(o.toString());
        o = redisTemplate.opsForList().rightPop("list");
        System.out.println(o.toString());
//        o = redisTemplate.opsForList().rightPop("list");
//        System.out.println(o.toString());
//        o = redisTemplate.opsForList().rightPop("list");
//        System.out.println(o);
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

    @Test
    public void testLock() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        RLock rLock = redissonClient.getLock("lock");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("当前线程："+ Thread.currentThread().getName()+",开始获取锁");
            rLock.lock();
            System.out.println("当前线程："+ Thread.currentThread().getName()+",获取锁");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rLock.unlock();
        });
        Thread.sleep(1000);
        if (rLock.tryLock(5, TimeUnit.SECONDS)) {
            stopwatch.stop();
            System.out.println(stopwatch);
            Thread.sleep(2000);
            rLock.unlock();

        }

    }
}
