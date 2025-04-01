package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.domain.CompScore;
import com.ruoyi.zhangyan.mapper.CompScoreMapper;
import com.ruoyi.zhangyan.service.ICompScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 成绩Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompScoreServiceImpl implements ICompScoreService {
    @Autowired
    private CompScoreMapper compScoreMapper;

    /**
     * 查询成绩
     *
     * @param scoreId 成绩主键
     * @return 成绩
     */
    @Override
    public CompScore selectCompScoreByScoreId(Long scoreId) {
        return compScoreMapper.selectCompScoreByScoreId(scoreId);
    }

    /**
     * 查询成绩列表
     *
     * @param compScore 成绩
     * @return 成绩
     */
    @Override
    public List<CompScore> selectCompScoreList(CompScore compScore) {
        return compScoreMapper.selectCompScoreList(compScore);
    }

    /**
     * 新增成绩
     *
     * @param compScore 成绩
     * @return 结果
     */
    @Override
    public int insertCompScore(CompScore compScore) {
        compScore.setCreateTime(DateUtils.getNowDate());
        return compScoreMapper.insertCompScore(compScore);
    }

    /**
     * 修改成绩
     *
     * @param compScore 成绩
     * @return 结果
     */
    @Override
    public int updateCompScore(CompScore compScore) {
        return compScoreMapper.updateCompScore(compScore);
    }

    /**
     * 批量删除成绩
     *
     * @param scoreIds 需要删除的成绩主键
     * @return 结果
     */
    @Override
    public int deleteCompScoreByScoreIds(String scoreIds) {
        return compScoreMapper.deleteCompScoreByScoreIds(Convert.toStrArray(scoreIds));
    }

    /**
     * 删除成绩信息
     *
     * @param scoreId 成绩主键
     * @return 结果
     */
    @Override
    public int deleteCompScoreByScoreId(Long scoreId) {
        return compScoreMapper.deleteCompScoreByScoreId(scoreId);
    }
}
