package com.example.backdemo.drool;

import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.entity.TradeInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 安全检查请求类
 * @author: superman
 * @create: 2020-02-11 18:38
 **/
@Data
public class SecurityCheckRequest implements Serializable {
    private static final long serialVersionUID = -2855148838350498522L;

    private TradeInfo tradeInfo;

    private SenderInfo senderInfo;
}
