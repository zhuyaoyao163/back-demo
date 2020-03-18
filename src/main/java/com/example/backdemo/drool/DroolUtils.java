package com.example.backdemo.drool;

import com.example.backdemo.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.drools.core.definitions.rule.impl.RuleImpl;

import java.util.Date;

/**
 * @description: drools工具类
 * @author: superman
 * @create: 2020-02-06 17:05
 **/
@Slf4j
public class DroolUtils {

    private static final boolean isPrint = true;

    public static boolean isNotEmptyPlus(String ruleName, Object... objects) {
        boolean flag = DroolUtils.isNotEmpty(objects);
        DroolUtils.print(getMethodFullName(), flag, objects, ruleName);
        return flag;
    }

    public static boolean isNotEmpty(Object... objects) {
        if (null == objects) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, objects);
            return false;
        }
        for(Object obj : objects) {
            if(null == obj) {
                //DroolUtils.print(DroolUtils.getMethodFullName(), false, objects);
                return false;
            }
            if(obj.toString().trim().length() <= 0) {
                //DroolUtils.print(DroolUtils.getMethodFullName(), false, objects);
                return false;
            }
        }
        //DroolUtils.print(DroolUtils.getMethodFullName(), true, objects);
        return true;
    }

    public static boolean isEmptyPlus(String ruleName, Object... objects) {
        boolean flag = DroolUtils.isEmpty(objects);
        DroolUtils.print(getMethodFullName(), flag, objects, ruleName);
        return flag;
    }

    public static boolean isEmpty(Object... objects) {
        if(null == objects) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), true, objects);
            return true;
        }
        for(Object obj : objects) {
            if(null != obj) {
                //DroolUtils.print(DroolUtils.getMethodFullName(), false, objects);
                return false;
            }
        }
        //DroolUtils.print(DroolUtils.getMethodFullName(), true, objects);
        return true;
    }

    public static boolean equalsPlus(String ruleName, Object a, Object b) {
        boolean flag = DroolUtils.equals(a, b);
        DroolUtils.print(getMethodFullName(), flag, a, b, ruleName);
        return flag;
    }

    public static boolean equals(Object a, Object b) {
        if(null == a) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b);
            return false;
        }
        if(null == b) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b);
            return false;
        }
        if(a.toString().trim().length() <= 0) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b);
            return false;
        }
        if(b.toString().trim().length() <= 0) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b);
            return false;
        }
        if(a.equals(b)) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), true, a, b);
            return true;
        }
        //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b);
        return false;
    }

    public static boolean isNotEquals(Object a, Object b){
        return !equals(a, b);
    }

    public static boolean equals(Object a, Object b, Object c) {
        if(null == a) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
            return false;
        }
        if(null == b) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
            return false;
        }
        if(null == c) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
            return false;
        }
        if(a.toString().trim().length() <= 0) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
            return false;
        }
        if(b.toString().trim().length() <= 0) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
            return false;
        }
        if(c.toString().trim().length() <= 0) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
            return false;
        }
        if(a.equals(b) && a.equals(c)) {
            //DroolUtils.print(DroolUtils.getMethodFullName(), true, a, b, c);
            return true;
        }
        //DroolUtils.print(DroolUtils.getMethodFullName(), false, a, b, c);
        return false;
    }

    private static String getMethodFullName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stackTrace[2];
        return e.getMethodName() + "({}) = {}";
    }

    private static void print(String methodName, boolean flag, Object... objects) {
        if(isPrint) log.debug(methodName, objects, flag);
    }

    public static boolean checkAmount(Object minAmount, Object maxAmount, Long tradeAmount) {
        if(null != minAmount) {
            Long min = Long.parseLong(minAmount.toString());
            if(tradeAmount < min) {
                //DroolUtils.print(DroolUtils.getMethodFullName(), true, tradeAmount, minAmount, maxAmount);
                return true;
            }
        }
        if(null != maxAmount) {
            Long max = Long.parseLong(maxAmount.toString());
            if(tradeAmount > max) {
                //DroolUtils.print(DroolUtils.getMethodFullName(), true, tradeAmount, minAmount, maxAmount);
                return true;
            }
        }
        //DroolUtils.print(DroolUtils.getMethodFullName(), false, tradeAmount, minAmount, maxAmount);
        return false;
    }

    public static void hit(RuleImpl rule, RuleInfo ruleInfo, TradeInfo tradeInfo, RiskRule riskRule) {
        try {
            if(null == ruleInfo) {
                ruleInfo = new RuleInfo();
            }
            ruleInfo.setId(riskRule.getId().toString());
            ruleInfo.setSalience(rule.getSalienceValue());
            ruleInfo.setGroup(rule.getActivationGroup());
            ruleInfo.setName(rule.getName());
            ruleInfo.setHitTime(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            ruleInfo.setExamineeId(tradeInfo.getApplyNo());
            ruleInfo.setResponseCode("01");
            ruleInfo.setResponseDesc("拒绝交易["+rule.getName()+"]");
            DroolUtils.print(getMethodFullName(), true, ruleInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hit(RuleImpl rule, RuleInfo ruleInfo, TradeInfo tradeInfo, SenderInfo senderInfo) {
        try {
            if(null == ruleInfo) {
                ruleInfo = new RuleInfo();
            }
            ruleInfo.setId(senderInfo.getUserId().toString());
            ruleInfo.setSalience(rule.getSalienceValue());
            ruleInfo.setGroup(rule.getActivationGroup());
            ruleInfo.setName(rule.getName());
            ruleInfo.setHitTime(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            if(tradeInfo != null)
            ruleInfo.setExamineeId(tradeInfo.getApplyNo());
            ruleInfo.setResponseCode("01");
            ruleInfo.setResponseDesc("拒绝交易["+rule.getName()+"]");
            DroolUtils.print(getMethodFullName(), true, ruleInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hit(RuleImpl rule, RuleInfo ruleInfo, TradeInfo tradeInfo, PayeeInfo payeeInfo) {
        try {
            if(null == ruleInfo) {
                ruleInfo = new RuleInfo();
            }
            ruleInfo.setId(payeeInfo.getPayeeId().toString());
            ruleInfo.setSalience(rule.getSalienceValue());
            ruleInfo.setGroup(rule.getActivationGroup());
            ruleInfo.setName(rule.getName());
            ruleInfo.setHitTime(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            ruleInfo.setExamineeId(tradeInfo.getApplyNo());
            ruleInfo.setResponseCode("01");
            ruleInfo.setResponseDesc("拒绝交易["+rule.getName()+"]");
            DroolUtils.print(getMethodFullName(), true, ruleInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hit(RuleImpl rule, RuleInfo ruleInfo, TradeInfo tradeInfo, CardInfo cardInfo) {
        try {
            if(null == ruleInfo) {
                ruleInfo = new RuleInfo();
            }
            ruleInfo.setId(cardInfo.getCardNo().toString());
            ruleInfo.setSalience(rule.getSalienceValue());
            ruleInfo.setGroup(rule.getActivationGroup());
            ruleInfo.setName(rule.getName());
            ruleInfo.setHitTime(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            ruleInfo.setExamineeId(tradeInfo.getApplyNo());
            ruleInfo.setResponseCode("01");
            ruleInfo.setResponseDesc("拒绝交易["+rule.getName()+"]");
            DroolUtils.print(getMethodFullName(), true, ruleInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean print(Object o, String name) {
        if (o == null) {
            log.info(name + ": ");
        }
        if (StringUtils.isEmpty(name)) {
            log.info(o.toString());
        } else {
            log.info(name + ": " + o.toString());
        }
        return true;
    }
}
