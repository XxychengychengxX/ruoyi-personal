package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.zhangyan.domain.CompCompetition;
import com.ruoyi.zhangyan.mapper.CompCompetitionMapper;
import com.ruoyi.zhangyan.service.ICompCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 赛事项目Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompCompetitionServiceImpl implements ICompCompetitionService {
    @Autowired
    private CompCompetitionMapper compCompetitionMapper;

    /**
     * 查询赛事项目
     *
     * @param competitionId 赛事项目主键
     * @return 赛事项目
     */
    @Override
    public CompCompetition selectCompCompetitionByCompetitionId(Long competitionId) {
        return compCompetitionMapper.selectCompCompetitionByCompetitionId(competitionId);
    }

    /**
     * 查询赛事项目列表
     *
     * @param compCompetition 赛事项目
     * @return 赛事项目
     */
    @Override
    public List<CompCompetition> selectCompCompetitionList(CompCompetition compCompetition) {
        return compCompetitionMapper.selectCompCompetitionList(compCompetition);
    }

    /**
     * 新增赛事项目
     *
     * @param compCompetition 赛事项目
     * @return 结果
     */
    @Override
    public int insertCompCompetition(CompCompetition compCompetition) {
        return compCompetitionMapper.insertCompCompetition(compCompetition);
    }

    /**
     * 修改赛事项目
     *
     * @param compCompetition 赛事项目
     * @return 结果
     */
    @Override
    public int updateCompCompetition(CompCompetition compCompetition) {
        return compCompetitionMapper.updateCompCompetition(compCompetition);
    }

    /**
     * 批量删除赛事项目
     *
     * @param competitionIds 需要删除的赛事项目主键
     * @return 结果
     */
    @Override
    public int deleteCompCompetitionByCompetitionIds(String competitionIds) {
        return compCompetitionMapper.deleteCompCompetitionByCompetitionIds(Convert.toStrArray(competitionIds));
    }

    /**
     * 删除赛事项目信息
     *
     * @param competitionId 赛事项目主键
     * @return 结果
     */
    @Override
    public int deleteCompCompetitionByCompetitionId(Long competitionId) {
        return compCompetitionMapper.deleteCompCompetitionByCompetitionId(competitionId);
    }
}
