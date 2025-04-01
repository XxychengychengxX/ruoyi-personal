package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.domain.CompActivity;
import com.ruoyi.zhangyan.mapper.CompActivityMapper;
import com.ruoyi.zhangyan.service.ICompActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文化活动Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompActivityServiceImpl implements ICompActivityService {
    @Autowired
    private CompActivityMapper compActivityMapper;

    /**
     * 查询文化活动
     *
     * @param activityId 文化活动主键
     * @return 文化活动
     */
    @Override
    public CompActivity selectCompActivityByActivityId(Long activityId) {
        return compActivityMapper.selectCompActivityByActivityId(activityId);
    }

    /**
     * 查询文化活动列表
     *
     * @param compActivity 文化活动
     * @return 文化活动
     */
    @Override
    public List<CompActivity> selectCompActivityList(CompActivity compActivity) {
        return compActivityMapper.selectCompActivityList(compActivity);
    }

    /**
     * 新增文化活动
     *
     * @param compActivity 文化活动
     * @return 结果
     */
    @Override
    public int insertCompActivity(CompActivity compActivity) {
        compActivity.setCreateTime(DateUtils.getNowDate());
        return compActivityMapper.insertCompActivity(compActivity);
    }

    /**
     * 修改文化活动
     *
     * @param compActivity 文化活动
     * @return 结果
     */
    @Override
    public int updateCompActivity(CompActivity compActivity) {
        compActivity.setUpdateTime(DateUtils.getNowDate());
        return compActivityMapper.updateCompActivity(compActivity);
    }

    /**
     * 批量删除文化活动
     *
     * @param activityIds 需要删除的文化活动主键
     * @return 结果
     */
    @Override
    public int deleteCompActivityByActivityIds(String activityIds) {
        return compActivityMapper.deleteCompActivityByActivityIds(Convert.toStrArray(activityIds));
    }

    /**
     * 删除文化活动信息
     *
     * @param activityId 文化活动主键
     * @return 结果
     */
    @Override
    public int deleteCompActivityByActivityId(Long activityId) {
        return compActivityMapper.deleteCompActivityByActivityId(activityId);
    }
}
