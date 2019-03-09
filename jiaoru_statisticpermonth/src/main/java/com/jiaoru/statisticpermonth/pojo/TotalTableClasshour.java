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



    private String trainerName;//
    private Integer time;//
    private Integer feePerTime;//
    private Integer totalFee;//
    private String activityReward;//
    private String subsidy;//
    private String deduction;//
    private String wagesPayable;//
    private Integer teachingGuarantee;//
    private Integer settlementAmount;//
    private Integer teachingGuaranteeOwe;//
    private String remarks;//


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Integer getTime() {
        return time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getFeePerTime() {
        return feePerTime;
    }
    public void setFeePerTime(Integer feePerTime) {
        this.feePerTime = feePerTime;
    }

    public Integer getTotalFee() {
        return totalFee;
    }
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getActivityReward() {
        return activityReward;
    }
    public void setActivityReward(String activityReward) {
        this.activityReward = activityReward;
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

    public String getWagesPayable() {
        return wagesPayable;
    }
    public void setWagesPayable(String wagesPayable) {
        this.wagesPayable = wagesPayable;
    }

    public Integer getTeachingGuarantee() {
        return teachingGuarantee;
    }

    public void setTeachingGuarantee(Integer teachingGuarantee) {
        this.teachingGuarantee = teachingGuarantee;
    }

    public Integer getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(Integer settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public Integer getTeachingGuaranteeOwe() {
        return teachingGuaranteeOwe;
    }

    public void setTeachingGuaranteeOwe(Integer teachingGuaranteeOwe) {
        this.teachingGuaranteeOwe = teachingGuaranteeOwe;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



}
