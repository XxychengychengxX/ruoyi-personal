package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.domain.CompTeam;
import com.ruoyi.zhangyan.mapper.CompTeamMapper;
import com.ruoyi.zhangyan.service.ICompTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 参赛团队Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompTeamServiceImpl implements ICompTeamService {
    @Autowired
    private CompTeamMapper compTeamMapper;

    /**
     * 查询参赛团队
     *
     * @param teamId 参赛团队主键
     * @return 参赛团队
     */
    @Override
    public CompTeam selectCompTeamByTeamId(Long teamId) {
        return compTeamMapper.selectCompTeamByTeamId(teamId);
    }

    /**
     * 查询参赛团队列表
     *
     * @param compTeam 参赛团队
     * @return 参赛团队
     */
    @Override
    public List<CompTeam> selectCompTeamList(CompTeam compTeam) {
        return compTeamMapper.selectCompTeamList(compTeam);
    }

    /**
     * 新增参赛团队
     *
     * @param compTeam 参赛团队
     * @return 结果
     */
    @Override
    public int insertCompTeam(CompTeam compTeam) {
        compTeam.setCreateTime(DateUtils.getNowDate());
        return compTeamMapper.insertCompTeam(compTeam);
    }

    /**
     * 修改参赛团队
     *
     * @param compTeam 参赛团队
     * @return 结果
     */
    @Override
    public int updateCompTeam(CompTeam compTeam) {
        return compTeamMapper.updateCompTeam(compTeam);
    }

    /**
     * 批量删除参赛团队
     *
     * @param teamIds 需要删除的参赛团队主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamByTeamIds(String teamIds) {
        return compTeamMapper.deleteCompTeamByTeamIds(Convert.toStrArray(teamIds));
    }

    /**
     * 删除参赛团队信息
     *
     * @param teamId 参赛团队主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamByTeamId(Long teamId) {
        return compTeamMapper.deleteCompTeamByTeamId(teamId);
    }
}
