package com.ruoyi.zhangyan.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 成绩对象 comp_score
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class CompScore extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 成绩ID
     */
    private Long scoreId;

    /**
     * 赛事ID
     */
    @Excel(name = "赛事ID")
    private Long competitionId;

    /**
     * 个人报名ID
     */
    @Excel(name = "个人报名ID")
    private Long registrationId;

    /**
     * 团队ID
     */
    @Excel(name = "团队ID")
    private Long teamId;

    /**
     * 成绩数值
     */
    @Excel(name = "成绩数值")
    private BigDecimal scoreValue;

    /**
     * 排名
     */
    @Excel(name = "排名")
    private Long ranking;

    /**
     * 证书存储路径
     */
    @Excel(name = "证书存储路径")
    private String certificatePath;

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setScoreValue(BigDecimal scoreValue) {
        this.scoreValue = scoreValue;
    }

    public BigDecimal getScoreValue() {
        return scoreValue;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    public Long getRanking() {
        return ranking;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("scoreId", getScoreId())
                .append("competitionId", getCompetitionId())
                .append("registrationId", getRegistrationId())
                .append("teamId", getTeamId())
                .append("scoreValue", getScoreValue())
                .append("ranking", getRanking())
                .append("certificatePath", getCertificatePath())
                .append("createTime", getCreateTime())
                .toString();
    }
}
