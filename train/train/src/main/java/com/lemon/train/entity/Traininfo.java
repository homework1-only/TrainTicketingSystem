package com.lemon.train.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Traininfo {
    private Integer id;

    private String startcity;

    private Date starttime;

    private String endcity;

    private Date endtime;

    private BigDecimal fprice;

    private BigDecimal sprice;

    private Integer fnum;

    private Integer snum;

    private Integer trainId;

    private String duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartcity() {
        return startcity;
    }

    public void setStartcity(String startcity) {
        this.startcity = startcity == null ? null : startcity.trim();
    }

    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getEndcity() {
        return endcity;
    }

    public void setEndcity(String endcity) {
        this.endcity = endcity == null ? null : endcity.trim();
    }

    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getFprice() {
        return fprice;
    }

    public void setFprice(BigDecimal fprice) {
        this.fprice = fprice;
    }

    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public Integer getFnum() {
        return fnum;
    }

    public void setFnum(Integer fnum) {
        this.fnum = fnum;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", startcity=").append(startcity);
        sb.append(", starttime=").append(starttime);
        sb.append(", endcity=").append(endcity);
        sb.append(", endtime=").append(endtime);
        sb.append(", fprice=").append(fprice);
        sb.append(", sprice=").append(sprice);
        sb.append(", fnum=").append(fnum);
        sb.append(", snum=").append(snum);
        sb.append(", trainId=").append(trainId);
        sb.append(", duration=").append(duration);
        sb.append("]");
        return sb.toString();
    }
}