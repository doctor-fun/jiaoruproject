package com.jiaoru.statisticpermonth.dao;

import com.jiaoru.statisticpermonth.pojo.TotalTableClasshour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TotalTableClasshourDao extends JpaRepository<TotalTableClasshour,String>, JpaSpecificationExecutor<TotalTableClasshour>
{

}
