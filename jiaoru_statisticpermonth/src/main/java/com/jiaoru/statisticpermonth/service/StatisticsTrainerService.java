package com.jiaoru.statisticpermonth.service;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.jiaoru.statisticpermonth.dao.StatisticsTrainerDao;
import com.jiaoru.statisticpermonth.pojo.StatisticsTrainer;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class StatisticsTrainerService {

	@Autowired
	private StatisticsTrainerDao statisticsTrainerDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<StatisticsTrainer> findAll() {
		return statisticsTrainerDao.findAll();
	}
	/**
	 * 查询指定名字的人的记录
	 *
	 */
	public Integer calculateSettlementAmount(String trainer){
		List<StatisticsTrainer> list=statisticsTrainerDao.findByTrainer(trainer);
		int SettlementAmount =0;
		int i=0;
		for(StatisticsTrainer statisticsTrainer: list){
			if(i!=list.size()-1)
			{
				SettlementAmount+=120;
				++i;
			}
		}
		return SettlementAmount;

	}
	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<StatisticsTrainer> findSearch(Map whereMap, int page, int size) {
		Specification<StatisticsTrainer> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return statisticsTrainerDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param
	 * @return
	 */
	public List<StatisticsTrainer> findSearchNoPage(StatisticsTrainer statisticsTrainer) {
		List<StatisticsTrainer> list;
		list=	statisticsTrainerDao.findAll(new Specification<StatisticsTrainer>() {
			/**
			 * 根对象，也就是要把条件封装到哪个对象中，where 类名=statisticsTrainer.get()条件
			 * @param root
			 * @param criteriaQuery
			 * @param criteriaBuilder 用来封装条件对象，如果直接返回null，则无条件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<StatisticsTrainer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list =new ArrayList<>();

				if(statisticsTrainer.getTrainer()!=null && !"".equals(statisticsTrainer.getTrainer())){
					Predicate predicate = criteriaBuilder.like(root.get("trainer").as(String.class), "%" + statisticsTrainer.getTrainer() + "%");
					//相当于//where statisticTrainer类中 类似于 "%中文字符%"
					list.add(predicate);
				}
				Predicate[] parr=new Predicate[list.size()];
				parr=list.toArray(parr);//将list的内容传给数组parr
				return criteriaBuilder.and(parr);
			}
		});

		return list;
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public StatisticsTrainer findById(String id) {
		return statisticsTrainerDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param statisticsTrainer
	 */
	public void add(StatisticsTrainer statisticsTrainer) {
		statisticsTrainer.setId( idWorker.nextId()+"" );
		statisticsTrainerDao.save(statisticsTrainer);
	}

	/**
	 * 修改
	 * @param statisticsTrainer
	 */
	public void update(StatisticsTrainer statisticsTrainer) {
		statisticsTrainerDao.save(statisticsTrainer);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		statisticsTrainerDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<StatisticsTrainer> createSpecification(Map searchMap) {

		return new Specification<StatisticsTrainer>() {

			@Override
			public Predicate toPredicate(Root<StatisticsTrainer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("month")!=null && !"".equals(searchMap.get("month"))) {
                	predicateList.add(cb.like(root.get("month").as(String.class), "%"+(String)searchMap.get("month")+"%"));
                }
                // 
                if (searchMap.get("trainer")!=null && !"".equals(searchMap.get("trainer"))) {
                	predicateList.add(cb.like(root.get("trainer").as(String.class), "%"+(String)searchMap.get("trainer")+"%"));
                }
                // 
                if (searchMap.get("date")!=null && !"".equals(searchMap.get("date"))) {
                	predicateList.add(cb.like(root.get("date").as(String.class), "%"+(String)searchMap.get("date")+"%"));
                }
                // 
                if (searchMap.get("community")!=null && !"".equals(searchMap.get("community"))) {
                	predicateList.add(cb.like(root.get("community").as(String.class), "%"+(String)searchMap.get("community")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
