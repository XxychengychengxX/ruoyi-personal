package com.ruoyi.zhangyan.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 赛事项目对象 comp_competition
 * 
 * @author XxychengychengxX
 * @date 2025-04-06
 */
public class CompCompetition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 赛事ID */
    private Long competitionId;

    /** 关联活动ID */
    @Excel(name = "关联活动ID")
    private Long activityId;

    /** 赛事名称 */
    @Excel(name = "赛事名称")
    private String competitionName;

    /** 赛事类型（0个人赛 1团队赛） */
    @Excel(name = "赛事类型", readConverterExp = "0=个人赛,1=团队赛")
    private String type;

    /** 赛事开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "赛事开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 赛事结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "赛事结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 组别分类（如按年级/专业） */
    @Excel(name = "组别分类", readConverterExp = "如=按年级/专业")
    private String groupType;

    /** 团队最大人数 */
    @Excel(name = "团队最大人数")
    private Long maxTeamMembers;

    public void setCompetitionId(Long competitionId) 
    {
        this.competitionId = competitionId;
    }

    public Long getCompetitionId() 
    {
        return competitionId;
    }

    public void setActivityId(Long activityId) 
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
    }

    public void setCompetitionName(String competitionName) 
    {
        this.competitionName = competitionName;
    }

    public String getCompetitionName() 
    {
        return competitionName;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setGroupType(String groupType) 
    {
        this.groupType = groupType;
    }

    public String getGroupType() 
    {
        return groupType;
    }

    public void setMaxTeamMembers(Long maxTeamMembers) 
    {
        this.maxTeamMembers = maxTeamMembers;
    }

    public Long getMaxTeamMembers() 
    {
        return maxTeamMembers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("competitionId", getCompetitionId())
            .append("activityId", getActivityId())
            .append("competitionName", getCompetitionName())
            .append("type", getType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("groupType", getGroupType())
            .append("maxTeamMembers", getMaxTeamMembers())
            .toString();
    }
}
