package com.jiaoru.statisticpermonth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jiaoru.statisticpermonth.pojo.StatisticsTrainer;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface StatisticsTrainerDao extends JpaRepository<StatisticsTrainer,String>,JpaSpecificationExecutor<StatisticsTrainer>{
	public List<StatisticsTrainer> findByTrainer(String trainer);
}
