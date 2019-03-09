package com.jiaoru.statisticpermonth.controller;

import com.jiaoru.statisticpermonth.pojo.StatisticsTrainer;
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
     *查看全部
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",totalTableClasshourService.findAll());
    }

    /**
     * 条件查询
     * @param totalTableClasshour
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody TotalTableClasshour totalTableClasshour){
        List<TotalTableClasshour> list=totalTableClasshourService.findSearchNoPage(totalTableClasshour);
        return new Result(true,StatusCode.OK,"查询成功了?",list);
    }

    /**
     *增加记录
     * @param totalTableClasshour
     * @return
     */
    @PostMapping
    public Result add(@RequestBody TotalTableClasshour totalTableClasshour){
        totalTableClasshourService.add(totalTableClasshour);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /**
     * 根据id修改行记录
     * @param totalTableClasshour
     */
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody TotalTableClasshour totalTableClasshour, @PathVariable String id ){
        totalTableClasshour.setId(id);
        totalTableClasshourService.update(totalTableClasshour);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 根据id删除
     * @param id
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        totalTableClasshourService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }




    

}
