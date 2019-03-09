package com.jiaoru.statisticpermonth.controller;

import com.jiaoru.statisticpermonth.service.TotalTableClasshourService;
import entity.Result;
import entity.StatusCode;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/totalTable")
public class TotalTableController {
    @Autowired
    private TotalTableClasshourService totalTableClasshourService;

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",totalTableClasshourService.findAll());
    }

    

}
