package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.domain.CompTeamMember;
import com.ruoyi.zhangyan.mapper.CompTeamMemberMapper;
import com.ruoyi.zhangyan.service.ICompTeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 团队成员Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompTeamMemberServiceImpl implements ICompTeamMemberService {
    @Autowired
    private CompTeamMemberMapper compTeamMemberMapper;

    /**
     * 查询团队成员
     *
     * @param memberId 团队成员主键
     * @return 团队成员
     */
    @Override
    public CompTeamMember selectCompTeamMemberByMemberId(Long memberId) {
        return compTeamMemberMapper.selectCompTeamMemberByMemberId(memberId);
    }

    /**
     * 查询团队成员列表
     *
     * @param compTeamMember 团队成员
     * @return 团队成员
     */
    @Override
    public List<CompTeamMember> selectCompTeamMemberList(CompTeamMember compTeamMember) {
        return compTeamMemberMapper.selectCompTeamMemberList(compTeamMember);
    }

    /**
     * 新增团队成员
     *
     * @param compTeamMember 团队成员
     * @return 结果
     */
    @Override
    public int insertCompTeamMember(CompTeamMember compTeamMember) {
        compTeamMember.setCreateTime(DateUtils.getNowDate());
        return compTeamMemberMapper.insertCompTeamMember(compTeamMember);
    }

    /**
     * 修改团队成员
     *
     * @param compTeamMember 团队成员
     * @return 结果
     */
    @Override
    public int updateCompTeamMember(CompTeamMember compTeamMember) {
        return compTeamMemberMapper.updateCompTeamMember(compTeamMember);
    }

    /**
     * 批量删除团队成员
     *
     * @param memberIds 需要删除的团队成员主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamMemberByMemberIds(String memberIds) {
        return compTeamMemberMapper.deleteCompTeamMemberByMemberIds(Convert.toStrArray(memberIds));
    }

    /**
     * 删除团队成员信息
     *
     * @param memberId 团队成员主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamMemberByMemberId(Long memberId) {
        return compTeamMemberMapper.deleteCompTeamMemberByMemberId(memberId);
    }
}
