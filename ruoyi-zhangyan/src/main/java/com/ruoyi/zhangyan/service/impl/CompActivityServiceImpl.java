package com.ruoyi.zhangyan.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.zhangyan.domain.CompCompetition;
import com.ruoyi.zhangyan.mapper.CompActivityMapper;
import com.ruoyi.zhangyan.domain.CompActivity;
import com.ruoyi.zhangyan.service.ICompActivityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文化活动Service业务层处理
 * 
 * @author XxychengychengxX
 * @date 2025-04-06
 */
@Service
public class CompActivityServiceImpl implements ICompActivityService 
{
    @Autowired
    private CompActivityMapper compActivityMapper;

    /**
     * 查询文化活动
     * 
     * @param activityId 文化活动主键
     * @return 文化活动
     */
    @Override
    public CompActivity selectCompActivityByActivityId(Long activityId)
    {
        return compActivityMapper.selectCompActivityByActivityId(activityId);
    }

    /**
     * 查询文化活动列表
     * 
     * @param compActivity 文化活动
     * @return 文化活动
     */
    @Override
    public List<CompActivity> selectCompActivityList(CompActivity compActivity)
    {
        return compActivityMapper.selectCompActivityList(compActivity);
    }

    /**
     * 新增文化活动
     * 
     * @param compActivity 文化活动
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCompActivity(CompActivity compActivity)
    {
        compActivity.setCreateTime(DateUtils.getNowDate());
        int rows = compActivityMapper.insertCompActivity(compActivity);
        insertCompCompetition(compActivity);
        return rows;
    }

    /**
     * 修改文化活动
     * 
     * @param compActivity 文化活动
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCompActivity(CompActivity compActivity)
    {
        compActivity.setUpdateTime(DateUtils.getNowDate());
        compActivityMapper.deleteCompCompetitionByActivityId(compActivity.getActivityId());
        insertCompCompetition(compActivity);
        return compActivityMapper.updateCompActivity(compActivity);
    }

    /**
     * 批量删除文化活动
     * 
     * @param activityIds 需要删除的文化活动主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCompActivityByActivityIds(String activityIds)
    {
        compActivityMapper.deleteCompCompetitionByActivityIds(Convert.toStrArray(activityIds));
        return compActivityMapper.deleteCompActivityByActivityIds(Convert.toStrArray(activityIds));
    }

    /**
     * 删除文化活动信息
     * 
     * @param activityId 文化活动主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCompActivityByActivityId(Long activityId)
    {
        compActivityMapper.deleteCompCompetitionByActivityId(activityId);
        return compActivityMapper.deleteCompActivityByActivityId(activityId);
    }

    /**
     * 新增赛事项目信息
     * 
     * @param compActivity 文化活动对象
     */
    public void insertCompCompetition(CompActivity compActivity)
    {
        List<CompCompetition> compCompetitionList = compActivity.getCompCompetitionList();
        Long activityId = compActivity.getActivityId();
        if (StringUtils.isNotNull(compCompetitionList))
        {
            List<CompCompetition> list = new ArrayList<CompCompetition>();
            for (CompCompetition compCompetition : compCompetitionList)
            {
                compCompetition.setActivityId(activityId);
                list.add(compCompetition);
            }
            if (list.size() > 0)
            {
                compActivityMapper.batchCompCompetition(list);
            }
        }
    }
}
