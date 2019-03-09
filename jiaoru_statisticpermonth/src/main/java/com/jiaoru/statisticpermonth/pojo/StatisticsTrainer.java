package com.jiaoru.statisticpermonth.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="classhour_statistics_trainer")
public class StatisticsTrainer implements Serializable{


	@Id
	private String id;//
	private String month;//
	private String trainer;//
	private String date;//
	private String community;//
	private Integer time;//

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getMonth() {		
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	public String getTrainer() {		
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getDate() {		
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getCommunity() {		
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}

	public Integer getTime() {		
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StatisticsTrainer{" +
				"id='" + id + '\'' +
				", month='" + month + '\'' +
				", trainer='" + trainer + '\'' +
				", date='" + date + '\'' +
				", community='" + community + '\'' +
				", time=" + time +
				'}';
	}
	
}
