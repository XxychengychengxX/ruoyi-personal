package com.ruoyi.zhangyan.mapper;

import com.ruoyi.zhangyan.domain.CompScore;

import java.util.List;

/**
 * 成绩Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface CompScoreMapper {
    /**
     * 查询成绩
     *
     * @param scoreId 成绩主键
     * @return 成绩
     */
    public CompScore selectCompScoreByScoreId(Long scoreId);

    /**
     * 查询成绩列表
     *
     * @param compScore 成绩
     * @return 成绩集合
     */
    public List<CompScore> selectCompScoreList(CompScore compScore);

    /**
     * 新增成绩
     *
     * @param compScore 成绩
     * @return 结果
     */
    public int insertCompScore(CompScore compScore);

    /**
     * 修改成绩
     *
     * @param compScore 成绩
     * @return 结果
     */
    public int updateCompScore(CompScore compScore);

    /**
     * 删除成绩
     *
     * @param scoreId 成绩主键
     * @return 结果
     */
    public int deleteCompScoreByScoreId(Long scoreId);

    /**
     * 批量删除成绩
     *
     * @param scoreIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompScoreByScoreIds(String[] scoreIds);
}
