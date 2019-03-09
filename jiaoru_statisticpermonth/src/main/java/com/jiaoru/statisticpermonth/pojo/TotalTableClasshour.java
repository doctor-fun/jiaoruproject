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
@Table(name="total_table_classhour")
public class TotalTableClasshour implements Serializable{

    @Id
    private String id;//



    private String trainername;//
    private Integer time;//
    private Integer feepertime;//
    private Integer totalfee;//
    private String activityreward;//
    private String subsidy;//
    private String deduction;//
    private String wagespayable;//

    @Override
    public String toString() {
        return "TotalTableClasshour{" +
                "id='" + id + '\'' +
                ", trainername='" + trainername + '\'' +
                ", time=" + time +
                ", feepertime=" + feepertime +
                ", totalfee=" + totalfee +
                ", activityreward='" + activityreward + '\'' +
                ", subsidy='" + subsidy + '\'' +
                ", deduction='" + deduction + '\'' +
                ", wagespayable='" + wagespayable + '\'' +
                ", teachingguarantee=" + teachingguarantee +
                ", settlementamount=" + settlementamount +
                ", teachingguaranteeowe=" + teachingguaranteeowe +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getFeepertime() {
        return feepertime;
    }

    public void setFeepertime(Integer feepertime) {
        this.feepertime = feepertime;
    }

    public Integer getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(Integer totalfee) {
        this.totalfee = totalfee;
    }

    public String getActivityreward() {
        return activityreward;
    }

    public void setActivityreward(String activityreward) {
        this.activityreward = activityreward;
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy;
    }

    public String getDeduction() {
        return deduction;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getWagespayable() {
        return wagespayable;
    }

    public void setWagespayable(String wagespayable) {
        this.wagespayable = wagespayable;
    }

    public Integer getTeachingguarantee() {
        return teachingguarantee;
    }

    public void setTeachingguarantee(Integer teachingguarantee) {
        this.teachingguarantee = teachingguarantee;
    }

    public Integer getSettlementamount() {
        return settlementamount;
    }

    public void setSettlementamount(Integer settlementamount) {
        this.settlementamount = settlementamount;
    }

    public Integer getTeachingguaranteeowe() {
        return teachingguaranteeowe;
    }

    public void setTeachingguaranteeowe(Integer teachingguaranteeowe) {
        this.teachingguaranteeowe = teachingguaranteeowe;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private Integer teachingguarantee;//
    private Integer settlementamount;//
    private Integer teachingguaranteeowe;//
    private String remarks;//



}
