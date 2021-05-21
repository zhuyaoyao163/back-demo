package com.example.backdemo.controller;


import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.service.ISenderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 风控汇款人信息 前端控制器
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Controller
@RequestMapping("/risk/sender-info")
public class SenderInfoController {

    @Autowired
    private ISenderInfoService senderInfoService;

    @GetMapping("/list")
    @ResponseBody
    public List<SenderInfo> list(){
        List<SenderInfo> list = senderInfoService.list();
        System.out.println(list.size());
        return list;
    }
}
