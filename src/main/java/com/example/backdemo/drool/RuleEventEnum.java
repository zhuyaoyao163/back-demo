package com.example.backdemo.drool;

public enum RuleEventEnum {

    SINGLE_ORDER_LIMIT_MIN_MONEY("SINGLE_ORDER_LIMIT_MIN_MONEY","单笔订单金额最小限制"),
    SINGLE_ORDER_LIMIT_MAX_MONEY("SINGLE_ORDER_LIMIT_MAX_MONEY","单笔订单金额最大限制"),
    SINGLE_DAY_LIMIT_NUMS("SINGLE_DAY_LIMIT_NUMS","单日完成订单状态笔数限制"),
    SINGLE_DAY_LIMIT_MONEY("SINGLE_DAY_LIMIT_MONEY","单日完成订单金额限制"),
    SINGLE_WEEKEND_LIMIT_NUMS("SINGLE_WEEKEND_LIMIT_NUMS","单周完成订单状态笔数限制"),
    SINGLE_WEEKEND_LIMIT_MONEY("SINGLE_WEEKEND_LIMIT_MONEY","单周完成订单金额限制"),
    SINGLE_MONTH_LIMIT_NUMS("SINGLE_MONTH_LIMIT_NUMS","单月完成订单状态笔数限制"),
    SINGLE_MONTH_LIMIT_MONEY("SINGLE_MONTH_LIMIT_MONEY","单月完成订单金额限制"),
    SINGLE_YEAR_CHINA_LIMIT_MONEY("SINGLE_YEAR_CHINA_LIMIT_MONEY","单人每年汇往中国地区限制"),
    SENDER_BLACK_NAME_LIST("SENDER_BLACK_NAME_LIST","汇款人黑名单"),
    PAYEE_BLACK_NAME_LIST("PAYEE_BLACK_NAME_LIST","收款人黑名单"),
    CARD_WHITE_NAME_LIST("CARD_WHITE_NAME_LIST","银行卡白名单"),
    CARD_BLACK_NAME_LIST("CARD_BLACK_NAME_LIST","银行卡黑名单"),
    CREDIT_CARD_RETRY_TIMES_TO_MUCH("CREDIT_CARD_RETRY_TIMES_TO_MUCH","信用卡重试次数过多"),
    CREDIT_CARD_BLACK_HISTORY_TWO_TIMES("CREDIT_CARD_BLACK_HISTORY_TWO_TIMES","（信用卡）加入黑名单的卡，下次再使用该卡支付时，连续输错2次，限制登录"),
    USER_IS_NOT_UNIQUE("USER_IS_NOT_UNIQUE","用户唯一性"),
    ;
    private String code;
    private String value;

    RuleEventEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public RuleEventEnum getRuleEventEnum(String key) {
        for (RuleEventEnum eventEnum : RuleEventEnum.values()) {
            if (eventEnum.getCode().equalsIgnoreCase(key)) {
                return eventEnum;
            }
        }
        return null;
    }
}
