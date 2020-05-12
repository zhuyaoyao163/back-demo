package com.example.backdemo.dataSource;

import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.entity.user.Appeal;
import com.example.backdemo.service.IRiskRuleService;
import com.example.backdemo.service.ISenderInfoService;
import com.example.backdemo.service.user.IAppealService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description:
 * @author: superman
 * @create: 2020-05-08 14:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DynamicDataSourceTest {

    @Autowired
    private IAppealService appealService;

    @Autowired
    private ISenderInfoService senderInfoService;

    @Autowired
    private IRiskRuleService riskRuleService;

    @Test
    public void test1() {
        List<Appeal> list = appealService.list();
        System.out.println(list);
        List<SenderInfo> senderInfos = senderInfoService.list();
        System.out.println(senderInfos);
//        List<RiskRule> list = riskRuleService.list();
//        System.out.println(list);
    }
}
