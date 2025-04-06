package com.ruoyi.zhangyan.mapper;

import java.util.List;
import com.ruoyi.zhangyan.domain.CompCompetition;

/**
 * 赛事项目Mapper接口
 * 
 * @author XxychengychengxX
 * @date 2025-04-06
 */
public interface CompCompetitionMapper 
{
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
     * 删除赛事项目
     * 
     * @param competitionId 赛事项目主键
     * @return 结果
     */
    public int deleteCompCompetitionByCompetitionId(Long competitionId);

    /**
     * 批量删除赛事项目
     * 
     * @param competitionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompCompetitionByCompetitionIds(String[] competitionIds);
}
