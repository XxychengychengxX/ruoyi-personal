package com.ruoyi.zhangyan.service;

import com.ruoyi.zhangyan.domain.CompTeam;

import java.util.List;

/**
 * 参赛团队Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface ICompTeamService {
    /**
     * 查询参赛团队
     *
     * @param teamId 参赛团队主键
     * @return 参赛团队
     */
    public CompTeam selectCompTeamByTeamId(Long teamId);

    /**
     * 查询参赛团队列表
     *
     * @param compTeam 参赛团队
     * @return 参赛团队集合
     */
    public List<CompTeam> selectCompTeamList(CompTeam compTeam);

    /**
     * 新增参赛团队
     *
     * @param compTeam 参赛团队
     * @return 结果
     */
    public int insertCompTeam(CompTeam compTeam);

    /**
     * 修改参赛团队
     *
     * @param compTeam 参赛团队
     * @return 结果
     */
    public int updateCompTeam(CompTeam compTeam);

    /**
     * 批量删除参赛团队
     *
     * @param teamIds 需要删除的参赛团队主键集合
     * @return 结果
     */
    public int deleteCompTeamByTeamIds(String teamIds);

    /**
     * 删除参赛团队信息
     *
     * @param teamId 参赛团队主键
     * @return 结果
     */
    public int deleteCompTeamByTeamId(Long teamId);
}
