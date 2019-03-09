package com.jiaoru.statisticpermonth.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiaoru.statisticpermonth.pojo.StatisticsTrainer;
import com.jiaoru.statisticpermonth.service.StatisticsTrainerService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/statisticsTrainer")
public class StatisticsTrainerController {

	@Autowired
	private StatisticsTrainerService statisticsTrainerService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",statisticsTrainerService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",statisticsTrainerService.findById(id));
	}
	/**
	 *
	 */

	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<StatisticsTrainer> pageList = statisticsTrainerService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<StatisticsTrainer>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody StatisticsTrainer statisticsTrainer){//将查询条件封装到Map当中
        List<StatisticsTrainer> list=statisticsTrainerService.findSearchNoPage(statisticsTrainer);
     	return new Result(true,StatusCode.OK,"查询成功了?",list);
    }
	
	/**
	 * 增加
	 * @param statisticsTrainer
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody StatisticsTrainer statisticsTrainer  ){
		statisticsTrainerService.add(statisticsTrainer);
		return new Result(true,StatusCode.OK,"增加成功");
	}

	
	/**
	 * 修改
	 * @param statisticsTrainer
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody StatisticsTrainer statisticsTrainer, @PathVariable String id ){
		statisticsTrainer.setId(id);
		statisticsTrainerService.update(statisticsTrainer);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		statisticsTrainerService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
