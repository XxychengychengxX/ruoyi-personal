package com.ruoyi.zhangyan.service;

import com.ruoyi.zhangyan.domain.CompCompetition;

import java.util.List;

/**
 * 赛事项目Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface ICompCompetitionService {
    /**
     * 查询赛事项目
     *
     * @param competitionId 赛事项目主键
     * @return 赛事项目
     */
    public CompCompetition selectCompCompetitionByCompetitionId(Long competitionId);

    /**
     * 查询赛事项目列表
     *
     * @param compCompetition 赛事项目
     * @return 赛事项目集合
     */
    public List<CompCompetition> selectCompCompetitionList(CompCompetition compCompetition);

    /**
     * 新增赛事项目
     *
     * @param compCompetition 赛事项目
     * @return 结果
     */
    public int insertCompCompetition(CompCompetition compCompetition);

    /**
     * 修改赛事项目
     *
     * @param compCompetition 赛事项目
     * @return 结果
     */
    public int updateCompCompetition(CompCompetition compCompetition);

    /**
     * 批量删除赛事项目
     *
     * @param competitionIds 需要删除的赛事项目主键集合
     * @return 结果
     */
    public int deleteCompCompetitionByCompetitionIds(String competitionIds);

    /**
     * 删除赛事项目信息
     *
     * @param competitionId 赛事项目主键
     * @return 结果
     */
    public int deleteCompCompetitionByCompetitionId(Long competitionId);
}
