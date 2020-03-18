package com.example.backdemo.drool;

public enum RiskLevelEnum {
    ORDER_FAIL(0, "订单失败"),
    PULL_BLACK_USER(1, "拉黑用户"),
    PULL_BLACK_USER_24_HOURS(2, "拉黑用户后24小时解除"),
    PULL_BLACK_USER_AND_NOT_LOGIN(3, "拉黑用户并限制登陆"),
    PULL_BLACK_USER_AND_NOT_PAYEE(4, "拉黑用户并且拉入收款人黑名单"),
    PULL_BLACK_CARD(5, "拉黑卡"),
    PULL_BLACK_CARD_24_HOURS(6, "拉黑卡后24小时解除"),
    ;

    private int level;
    private String desc;

    RiskLevelEnum(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
