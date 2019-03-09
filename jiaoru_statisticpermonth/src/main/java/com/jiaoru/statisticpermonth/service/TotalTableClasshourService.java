package com.jiaoru.statisticpermonth.service;

import com.jiaoru.statisticpermonth.dao.TotalTableClasshourDao;
import com.jiaoru.statisticpermonth.pojo.TotalTableClasshour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class TotalTableClasshourService {
    @Autowired
    private TotalTableClasshourDao totalTableClasshourDao;
    @Autowired
    private IdWorker idWorker;

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
