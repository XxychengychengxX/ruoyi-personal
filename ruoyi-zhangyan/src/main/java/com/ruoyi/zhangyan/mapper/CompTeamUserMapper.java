package com.ruoyi.zhangyan.mapper;

import com.ruoyi.zhangyan.domain.CompTeamUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 团队成员管理Mapper接口
 *
 * @author XxychengychengxX
 * @date 2025-04-12
 */
public interface CompTeamUserMapper {
    /**
     * 查询团队成员管理
     *
     * @param id 团队成员管理主键
     * @return 团队成员管理
     */
    public CompTeamUser selectCompTeamUserById(Long id);



    /**
     * 查询团队成员管理列表
     *
     * @param compTeamUser 团队成员管理
     * @return 团队成员管理集合
     */
    public List<CompTeamUser> selectCompTeamUserList(CompTeamUser compTeamUser);

    /**
     * 新增团队成员管理
     *
     * @param compTeamUser 团队成员管理
     * @return 结果
     */
    public int insertCompTeamUser(CompTeamUser compTeamUser);

    /**
     * 修改团队成员管理
     *
     * @param compTeamUser 团队成员管理
     * @return 结果
     */
    public int updateCompTeamUser(CompTeamUser compTeamUser);

    /**
     * 删除团队成员管理
     *
     * @param id 团队成员管理主键
     * @return 结果
     */
    public int deleteCompTeamUserById(Long id);

    /**
     * 批量删除团队成员管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompTeamUserByIds(String[] ids);

    /**
     * 根据队伍id查询成员
     * @param teamId 队伍id
     * @return 成员列表
     */
    List<CompTeamUser> selectCompTeamUserByTeamIdAndUserId(@Param("teamId") Long teamId, @Param("userId") Long userId);
}
