package com.ruoyi.zhangyan.service;

import com.ruoyi.zhangyan.domain.CompTeamMember;

import java.util.List;

/**
 * 团队成员Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface ICompTeamMemberService {
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
     * 批量删除团队成员
     *
     * @param memberIds 需要删除的团队成员主键集合
     * @return 结果
     */
    public int deleteCompTeamMemberByMemberIds(String memberIds);

    /**
     * 删除团队成员信息
     *
     * @param memberId 团队成员主键
     * @return 结果
     */
    public int deleteCompTeamMemberByMemberId(Long memberId);
}
