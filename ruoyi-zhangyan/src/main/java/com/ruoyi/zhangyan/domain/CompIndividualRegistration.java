package com.ruoyi.zhangyan.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 个人报名对象 comp_individual_registration
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class CompIndividualRegistration extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 报名ID
     */
    private Long registrationId;

    /**
     * 赛事ID
     */
    @Excel(name = "赛事ID")
    private Long competitionId;

    /**
     * 若依用户ID（预留字段）
     */
    @Excel(name = "若依用户ID", readConverterExp = "预=留字段")
    private Long userId;

    /**
     * 真实姓名
     */
    @Excel(name = "真实姓名")
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

    /**
     * 所属组别（如计算机系2023级）
     */
    @Excel(name = "所属组别", readConverterExp = "如=计算机系2023级")
    private String groupInfo;

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
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

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("registrationId", getRegistrationId())
                .append("competitionId", getCompetitionId())
                .append("userId", getUserId())
                .append("realName", getRealName())
                .append("idCard", getIdCard())
                .append("contact", getContact())
                .append("groupInfo", getGroupInfo())
                .append("createTime", getCreateTime())
                .toString();
    }
}
