package com.jiaoru.statisticpermonth.controller;

import com.jiaoru.statisticpermonth.service.TotalTableClasshourService;
import entity.Result;
import entity.StatusCode;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/totalTable")
public class TotalTableController {
    @Autowired
    private TotalTableClasshourService totalTableClasshourService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",totalTableClasshourService.findAll());
    }

    

}
