package com.jiaoru.statisticpermonth.service;

import com.jiaoru.statisticpermonth.dao.TotalTableClasshourDao;

import com.jiaoru.statisticpermonth.pojo.TotalTableClasshour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
;
import java.util.ArrayList;
import java.util.List;

@Service
public class TotalTableClasshourService {
    @Autowired
    private TotalTableClasshourDao totalTableClasshourDao;
    @Autowired
    private IdWorker idWorker;

    /**
     *
     * @param totalTableClasshour
     * @return
     */
    public  List<TotalTableClasshour> findSearchNoPage(TotalTableClasshour totalTableClasshour) {
        List<TotalTableClasshour> list;
        list=totalTableClasshourDao.findAll(new Specification<TotalTableClasshour>() {
            /**
             * 根对象，也就是要把条件封装到哪个对象中，where 类名=statisticsTrainer.get()条件
             * @param root
             * @param criteriaQuery
             * @param criteriaBuilder 用来封装条件对象，如果直接返回null，则无条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<TotalTableClasshour> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list =new ArrayList<>();

                if(totalTableClasshour.getTrainername()!=null && !"".equals(totalTableClasshour.getTrainername())){
                    Predicate predicate = criteriaBuilder.like(root.get("trainername").as(String.class), "%" + totalTableClasshour.getTrainername() + "%");
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
     *
     * @return
     */
    public List<TotalTableClasshour> findAll(){
        return totalTableClasshourDao.findAll();
    }

    /**
     * 保存
     * @param totalTableClasshour
     */
    public void add(TotalTableClasshour totalTableClasshour){
        totalTableClasshour.setId(idWorker.nextId()+"");
        totalTableClasshourDao.save(totalTableClasshour);
    }

    /**
     * 应该先add再update
     * @param totalTableClasshour
     */
    public void update(TotalTableClasshour totalTableClasshour){
        totalTableClasshourDao.save(totalTableClasshour);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id){
        totalTableClasshourDao.deleteById(id);
    }

 }
