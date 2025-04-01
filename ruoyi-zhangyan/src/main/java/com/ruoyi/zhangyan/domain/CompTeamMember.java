package com.ruoyi.zhangyan.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 团队成员对象 comp_team_member
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class CompTeamMember extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 成员ID
     */
    private Long memberId;

    /**
     * 团队ID
     */
    @Excel(name = "团队ID")
    private Long teamId;

    /**
     * 成员姓名
     */
    @Excel(name = "成员姓名")
    private String realName;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idCard;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String contact;

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("memberId", getMemberId())
                .append("teamId", getTeamId())
                .append("realName", getRealName())
                .append("idCard", getIdCard())
                .append("contact", getContact())
                .append("createTime", getCreateTime())
                .toString();
    }
}
