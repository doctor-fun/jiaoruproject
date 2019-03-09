package com.jiaoru.statisticpermonth.controller;

import com.jiaoru.statisticpermonth.pojo.TotalTableClasshour;
import com.jiaoru.statisticpermonth.service.TotalTableClasshourService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody TotalTableClasshour totalTableClasshour){
        List<TotalTableClasshour> list=totalTableClasshourService.findSearchNoPage(totalTableClasshour);
        return new Result(true,StatusCode.OK,"查询成功了?",list);
    }

    

}
