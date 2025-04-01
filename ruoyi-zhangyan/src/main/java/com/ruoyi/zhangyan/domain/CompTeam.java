package com.ruoyi.zhangyan.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 参赛团队对象 comp_team
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class CompTeam extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 团队ID
     */
    private Long teamId;

    /**
     * 赛事ID
     */
    @Excel(name = "赛事ID")
    private Long competitionId;

    /**
     * 团队名称
     */
    @Excel(name = "团队名称")
    private String teamName;

    /**
     * 队长身份证号
     */
    @Excel(name = "队长身份证号")
    private String captainIdCard;

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setCaptainIdCard(String captainIdCard) {
        this.captainIdCard = captainIdCard;
    }

    public String getCaptainIdCard() {
        return captainIdCard;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("teamId", getTeamId())
                .append("competitionId", getCompetitionId())
                .append("teamName", getTeamName())
                .append("captainIdCard", getCaptainIdCard())
                .append("createTime", getCreateTime())
                .toString();
    }
}
