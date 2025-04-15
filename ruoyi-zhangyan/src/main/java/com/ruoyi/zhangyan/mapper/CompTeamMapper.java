package com.ruoyi.zhangyan.mapper;

import java.util.List;
import java.util.Set;

import com.ruoyi.zhangyan.domain.CompTeam;
import org.apache.ibatis.annotations.Param;

/**
 * 团队管理Mapper接口
 * 
 * @author XxychengychengxX
 * @date 2025-04-11
 */
public interface CompTeamMapper 
{
    /**
     * 查询团队管理
     * 
     * @param teamId 团队管理主键
     * @return 团队管理
     */
    public CompTeam selectCompTeamByTeamId(Long teamId);

    /**
     * 查询团队管理列表
     * 
     * @param compTeam 团队管理
     * @return 团队管理集合
     */
    public List<CompTeam> selectCompTeamList(CompTeam compTeam);

    /**
     * 新增团队管理
     * 
     * @param compTeam 团队管理
     * @return 结果
     */
    public int insertCompTeam(CompTeam compTeam);

    /**
     * 修改团队管理
     * 
     * @param compTeam 团队管理
     * @return 结果
     */
    public int updateCompTeam(CompTeam compTeam);

    /**
     * 删除团队管理
     * 
     * @param teamId 团队管理主键
     * @return 结果
     */
    public int deleteCompTeamByTeamId(Long teamId);

    /**
     * 批量删除团队管理
     * 
     * @param teamIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompTeamByTeamIds(String[] teamIds);

    List<CompTeam> selectCompTeamListByTeamId(@Param("teamId") Set<Long> teamId);
}
