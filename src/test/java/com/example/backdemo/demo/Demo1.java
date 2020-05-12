package com.example.backdemo.demo;
import java.io.IOException;
import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.entity.TradeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: superman
 * @create: 2020-01-20 18:09
 **/
@Slf4j
public class Demo1 {



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

    public static void test6() {
        Preconditions.checkArgument(1 == 2, "1 不等于2");
        Objects.equal(null, null);
        MoreObjects.firstNonNull(null, null);
    }


    public static void test7() {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
        List<String> list1 = list.subList(0, 3);
        list1.stream().forEach(System.out::println);
        String s = list1.stream().filter(a -> a.equalsIgnoreCase("6")).findFirst().orElse(null);
        System.out.println(s);
    }

    public static void test8() {
        String join = Joiner.on(" ").skipNulls().join(new String[]{"a", ""});
        System.out.println(join);
    }

    public static void test9() {
        String a = null;
        if (StringUtils.isEmpty(a)) {
            throw new HitRuleException("test exception");
        }
    }


    private static HashMap<String, Object> decodeResponse(String callbackData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> data = Maps.newHashMap();
        data = (HashMap)mapper.readValue(callbackData, new TypeReference<Map<String, Object>>() {
        });
        return data;
    }

    private static Object getValueByName(String name, Map<String, Object> data) {
        Object value = data.get(name);
        if (value != null) {
            return value;
        } else {
            Iterator var4 = data.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var4.next();
                Object entryValue = entry.getValue();
                if (entryValue instanceof Map) {
                    Object subValue = getValueByName(name, (HashMap)entryValue);
                    if (subValue != "") {
                        return subValue;
                    }
                }
            }

            return "";
        }
    }

    private static void test10() throws JsonProcessingException {
        String str = "{\n" +
                "\t\"project_id\": 4651,\n" +
                "\t\"payment\": {\n" +
                "\t\t\"id\": \"30696739168562319361\",\n" +
                "\t\t\"type\": \"purchase\",\n" +
                "\t\t\"status\": \"success\",\n" +
                "\t\t\"date\": \"2020-04-07T06:22:36+0000\",\n" +
                "\t\t\"method\": \"card\",\n" +
                "\t\t\"sum\": {\n" +
                "\t\t\t\"amount\": 148065,\n" +
                "\t\t\t\"currency\": \"EUR\"\n" +
                "\t\t},\n" +
                "\t\t\"description\": \"transfer money to OTrasnfer\"\n" +
                "\t},\n" +
                "\t\"account\": {\n" +
                "\t\t\"number\": \"555555******4444\",\n" +
                "\t\t\"token\": \"3f399d5b395cf5e8b59f12e9dcbdc15362d2cce4bc22840fa00e8283824f4054\",\n" +
                "\t\t\"type\": \"mastercard\",\n" +
                "\t\t\"id\": 95951491,\n" +
                "\t\t\"card_holder\": \"LIU ZHENZHEN\",\n" +
                "\t\t\"expiry_month\": \"02\",\n" +
                "\t\t\"expiry_year\": \"2023\"\n" +
                "\t},\n" +
                "\t\"customer\": {\n" +
                "\t\t\"id\": \"475\"\n" +
                "\t},\n" +
                "\t\"operation\": {\n" +
                "\t\t\"id\": 57982000038011,\n" +
                "\t\t\"type\": \"sale\",\n" +
                "\t\t\"status\": \"success\",\n" +
                "\t\t\"date\": \"2020-04-07T06:22:36+0000\",\n" +
                "\t\t\"created_date\": \"2020-04-07T06:22:34+0000\",\n" +
                "\t\t\"request_id\": \"05ed01b609f2e8f66c4bf3f1149cbd50329a95b7-e065a63696b307564aee233b8e668fdd5cc982c9-00057983\",\n" +
                "\t\t\"sum_initial\": {\n" +
                "\t\t\t\"amount\": 148065,\n" +
                "\t\t\t\"currency\": \"EUR\"\n" +
                "\t\t},\n" +
                "\t\t\"sum_converted\": {\n" +
                "\t\t\t\"amount\": 148065,\n" +
                "\t\t\t\"currency\": \"EUR\"\n" +
                "\t\t},\n" +
                "\t\t\"code\": \"0\",\n" +
                "\t\t\"message\": \"Success\",\n" +
                "\t\t\"eci\": \"00\",\n" +
                "\t\t\"provider\": {\n" +
                "\t\t\t\"id\": 6,\n" +
                "\t\t\t\"payment_id\": \"15862405552662\",\n" +
                "\t\t\t\"auth_code\": \"563253\",\n" +
                "\t\t\t\"endpoint_id\": 6,\n" +
                "\t\t\t\"date\": \"2018-02-07T08:34:24+0000\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"signature\": \"SfuwtC0sqPw+41nDXrzLhUXx84XWka5vSQgi6fj\\/A\\/7UAqw22vryF1dEFRvaYdRieemVsTaxUf2CA+IQ33YhDQ==\"\n" +
                "}";
        HashMap<String, Object> stringObjectHashMap = decodeResponse(str);
        Object account = getValueByName("type", stringObjectHashMap);
        System.out.println(JSON.toJSONString(account));
    }


    public static void test11() {
//        Stream.generate()
        String firstName = "SASD   SDA";
        String lastName = "asas";
        String str1 = Joiner.on(" ").skipNulls().join(firstName, lastName);
        List<String> list = Splitter.on(" ").omitEmptyStrings().splitToList(str1);

        String str2 = "asas SDA";
        List<String> list2 = Splitter.on(" ").omitEmptyStrings().splitToList(str2);
        System.out.println(list.containsAll(list2));
        list.forEach(System.out::println);
    }


    @Test
    public void testFinal() {
        String str = "aaa";
        final String a = str;
        System.out.println(a);

        str = "bbb";
        System.out.println(a);
    }

    @Test
    public void testJack() {
        ObjectMapper objectMapper = new ObjectMapper();
    }


    public static void main(String[] args) throws JsonProcessingException {
//        System.out.println(Demo1.test());
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test7();
//        test8();
//        test9();
//        test10();
        test11();

    }
}
