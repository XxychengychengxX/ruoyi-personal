package com.ruoyi.zhangyan.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.dto.req.CompTeamApplyRequest;
import com.ruoyi.zhangyan.mapper.CompTeamUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zhangyan.mapper.CompTeamMapper;
import com.ruoyi.zhangyan.domain.CompTeam;
import com.ruoyi.zhangyan.service.ICompTeamService;
import com.ruoyi.common.core.text.Convert;

/**
 * 团队管理Service业务层处理
 * 
 * @author XxychengychengxX
 * @date 2025-04-11
 */
@Service
public class CompTeamServiceImpl implements ICompTeamService 
{
    @Autowired
    private CompTeamMapper compTeamMapper;
    @Autowired
    private CompTeamUserMapper compTeamUserMapper;

    /**
     * 查询团队管理
     * 
     * @param teamId 团队管理主键
     * @return 团队管理
     */
    @Override
    public CompTeam selectCompTeamByTeamId(Long teamId)
    {
        return compTeamMapper.selectCompTeamByTeamId(teamId);
    }

    /**
     * 查询团队管理列表
     * 
     * @param compTeam 团队管理
     * @return 团队管理
     */
    @Override
    public List<CompTeam> selectCompTeamList(CompTeam compTeam)
    {
        return compTeamMapper.selectCompTeamList(compTeam);
    }

    /**
     * 新增团队管理
     * 
     * @param compTeam 团队管理
     * @return 结果
     */
    @Override
    public int insertCompTeam(CompTeam compTeam)
    {
        compTeam.setCreateTime(DateUtils.getNowDate());
        return compTeamMapper.insertCompTeam(compTeam);
    }

    /**
     * 修改团队管理
     * 
     * @param compTeam 团队管理
     * @return 结果
     */
    @Override
    public int updateCompTeam(CompTeam compTeam)
    {
        return compTeamMapper.updateCompTeam(compTeam);
    }

    /**
     * 批量删除团队管理
     * 
     * @param teamIds 需要删除的团队管理主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamByTeamIds(String teamIds)
    {
        return compTeamMapper.deleteCompTeamByTeamIds(Convert.toStrArray(teamIds));
    }

    /**
     * 删除团队管理信息
     * 
     * @param teamId 团队管理主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamByTeamId(Long teamId)
    {
        return compTeamMapper.deleteCompTeamByTeamId(teamId);
    }

    @Override
    public boolean applyTeam(CompTeamApplyRequest req) {
        // 这里可以添加具体的报名逻辑，例如检查团队是否已满，用户是否已经报名等
        Long teamId = req.getTeamId();
        // 示例：打印日志表示收到报名请求
        System.out.println("收到团队 " + teamId + " 的报名请求");
        // 可以调用 mapper 进行数据库操作，例如添加报名记录
        // compTeamMapper.insertApplyRecord(req);
        return true;
    }
}
