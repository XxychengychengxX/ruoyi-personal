package com.ruoyi.zhangyan.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 团队管理对象 comp_team
 *
 * @author XxychengychengxX
 * @date 2025-04-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CompTeam extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long teamId;

    /**
     *
     */
    @Excel(name = "队伍名")
    private String teamName;

    /**
     * 队长用户ID
     */
    @Excel(name = "队长用户ID")
    private Long captainUserId;

    /**
     * 队长用户名
     */
    @Excel(name = "队长用户名")
    private String captainUsername;
    /**
     * 队伍最多人数
     */
    @Excel(name = "队伍最多人数")
    private Long maxMemberNum;


    @Excel(name = "队伍描述")
    private String description;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("teamId", getTeamId())
                .append("teamName", getTeamName())
                .append("captainUserId", getCaptainUserId())
                .append("createTime", getCreateTime())
                .append("maxMemberNum", getMaxMemberNum())
                .toString();
    }
}
