package com.ruoyi.zhangyan.service;

import java.util.List;
import com.ruoyi.zhangyan.domain.CompTeam;
import com.ruoyi.zhangyan.dto.req.CompTeamApplyRequest;

/**
 * 团队管理Service接口
 * 
 * @author XxychengychengxX
 * @date 2025-04-11
 */
public interface ICompTeamService 
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
     * 批量删除团队管理
     * 
     * @param teamIds 需要删除的团队管理主键集合
     * @return 结果
     */
    public int deleteCompTeamByTeamIds(String teamIds);

    /**
     * 删除团队管理信息
     * 
     * @param teamId 团队管理主键
     * @return 结果
     */
    public int deleteCompTeamByTeamId(Long teamId);

    /**
     * 申请加入队伍
     *
     * @param req 请求体
     */
    boolean applyTeam(CompTeamApplyRequest req);

    /**
     * 列出我加入的队伍
     *
     * @param userId 用户ID
     * @return 队伍列表
     */
    List<CompTeam> listMine(Long userId);
}
