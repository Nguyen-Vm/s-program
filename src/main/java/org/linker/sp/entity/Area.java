package org.linker.sp.entity;

import java.util.Date;

/**
 * @author RWM
 * @date 2018/5/23
 */
public class Area {

    private Integer areaId;

    private String areaName;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    public Area() {
    }

    public Area(String areaName, Integer priority) {
        this.areaName = areaName;
        this.priority = priority;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
