package com.ruoyi.zhangyan.mapper;

import com.ruoyi.zhangyan.domain.CompTeamMember;

import java.util.List;

/**
 * 团队成员Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface CompTeamMemberMapper {
    /**
     * 查询团队成员
     *
     * @param memberId 团队成员主键
     * @return 团队成员
     */
    public CompTeamMember selectCompTeamMemberByMemberId(Long memberId);

    /**
     * 查询团队成员列表
     *
     * @param compTeamMember 团队成员
     * @return 团队成员集合
     */
    public List<CompTeamMember> selectCompTeamMemberList(CompTeamMember compTeamMember);

    /**
     * 新增团队成员
     *
     * @param compTeamMember 团队成员
     * @return 结果
     */
    public int insertCompTeamMember(CompTeamMember compTeamMember);

    /**
     * 修改团队成员
     *
     * @param compTeamMember 团队成员
     * @return 结果
     */
    public int updateCompTeamMember(CompTeamMember compTeamMember);

    /**
     * 删除团队成员
     *
     * @param memberId 团队成员主键
     * @return 结果
     */
    public int deleteCompTeamMemberByMemberId(Long memberId);

    /**
     * 批量删除团队成员
     *
     * @param memberIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompTeamMemberByMemberIds(String[] memberIds);
}
