package com.example.backdemo.demo;
import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.example.backdemo.entity.TradeInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: superman
 * @create: 2020-01-20 18:09
 **/
public class Demo1 {

    public static void main(String[] args) {
//        System.out.println(Demo1.test());
//        test1();
//        test2();
//        test3();
//        test4();
        test5();

    }

    // 求最终打印结果
    private static String test(){
        String a = new String("a");
        WeakReference<String> b = new WeakReference<String>(a);
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<String, Integer>();
        weakMap.put(b.get(), 1);
        a = null;
        System.gc();
        String c = "";
        try{
            c = b.get().replace("a", "b");
            return c;
        }catch(Exception e){
            c = "c";
            return c;
        }finally{
            c += "d";
            return c + "e";
        }
    }

    private static void test1() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        List<Integer> list = Lists.newArrayList();
        BeanUtils.copyProperties(integers, list);
        list.stream().forEach(a -> System.out.println(a));
        Object[] array = integers.toArray();
        Object[] integers1 = Arrays.copyOf(array, array.length);
        ArrayList<Object> integers2 = Lists.newArrayList(integers1);
        integers2.stream().forEach(a-> System.out.println(a));
    }

    private static void test2() {
        boolean noneEmpty = StringUtils.isNoneEmpty(" ");
        System.out.println(noneEmpty);
    }

    private static void test3() {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal decimal = a.add(BigDecimal.ONE);
        System.out.println(a);
        System.out.println(decimal);
    }

    private static void test4() {
        List<TradeInfo> list = Lists.newArrayList();
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setId(1);
        tradeInfo.setPayeeId(0);
        tradeInfo.setPayerId(0);
        tradeInfo.setApplyNo("");
        tradeInfo.setCurrency("");
        tradeInfo.setAmount(new BigDecimal("0"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreator("");
        tradeInfo.setCreateTime(LocalDateTime.now());
        tradeInfo.setUpdater("");
        tradeInfo.setUpdateTime(LocalDateTime.now());
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");
        tradeInfo.setCardType(0);
        tradeInfo.setCardNo("");

        list.add(tradeInfo);

        for (TradeInfo info : list) {
            info.setAmount(BigDecimal.TEN);
        }

        System.out.println(JSON.toJSONString(list));
    }


    public static void test5() {
        List<TradeInfo> list = null;
        List<String> collect = list.stream().map(a -> a.getApplyNo()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }
}
