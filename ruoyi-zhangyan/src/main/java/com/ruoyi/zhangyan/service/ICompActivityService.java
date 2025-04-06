package com.ruoyi.zhangyan.service;

import java.util.List;
import com.ruoyi.zhangyan.domain.CompActivity;

/**
 * 文化活动Service接口
 * 
 * @author XxychengychengxX
 * @date 2025-04-06
 */
public interface ICompActivityService 
{
    /**
     * 查询文化活动
     * 
     * @param activityId 文化活动主键
     * @return 文化活动
     */
    public CompActivity selectCompActivityByActivityId(Long activityId);

    /**
     * 查询文化活动列表
     * 
     * @param compActivity 文化活动
     * @return 文化活动集合
     */
    public List<CompActivity> selectCompActivityList(CompActivity compActivity);

    /**
     * 新增文化活动
     * 
     * @param compActivity 文化活动
     * @return 结果
     */
    public int insertCompActivity(CompActivity compActivity);

    /**
     * 修改文化活动
     * 
     * @param compActivity 文化活动
     * @return 结果
     */
    public int updateCompActivity(CompActivity compActivity);

    /**
     * 批量删除文化活动
     * 
     * @param activityIds 需要删除的文化活动主键集合
     * @return 结果
     */
    public int deleteCompActivityByActivityIds(String activityIds);

    /**
     * 删除文化活动信息
     * 
     * @param activityId 文化活动主键
     * @return 结果
     */
    public int deleteCompActivityByActivityId(Long activityId);
}
