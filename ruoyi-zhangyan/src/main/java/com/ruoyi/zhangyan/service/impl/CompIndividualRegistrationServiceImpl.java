package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.domain.CompIndividualRegistration;
import com.ruoyi.zhangyan.mapper.CompIndividualRegistrationMapper;
import com.ruoyi.zhangyan.service.ICompIndividualRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 个人报名Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompIndividualRegistrationServiceImpl implements ICompIndividualRegistrationService {
    @Autowired
    private CompIndividualRegistrationMapper compIndividualRegistrationMapper;

    /**
     * 查询个人报名
     *
     * @param registrationId 个人报名主键
     * @return 个人报名
     */
    @Override
    public CompIndividualRegistration selectCompIndividualRegistrationByRegistrationId(Long registrationId) {
        return compIndividualRegistrationMapper.selectCompIndividualRegistrationByRegistrationId(registrationId);
    }

    /**
     * 查询个人报名列表
     *
     * @param compIndividualRegistration 个人报名
     * @return 个人报名
     */
    @Override
    public List<CompIndividualRegistration> selectCompIndividualRegistrationList(CompIndividualRegistration compIndividualRegistration) {
        return compIndividualRegistrationMapper.selectCompIndividualRegistrationList(compIndividualRegistration);
    }

    /**
     * 新增个人报名
     *
     * @param compIndividualRegistration 个人报名
     * @return 结果
     */
    @Override
    public int insertCompIndividualRegistration(CompIndividualRegistration compIndividualRegistration) {
        compIndividualRegistration.setCreateTime(DateUtils.getNowDate());
        return compIndividualRegistrationMapper.insertCompIndividualRegistration(compIndividualRegistration);
    }

    /**
     * 修改个人报名
     *
     * @param compIndividualRegistration 个人报名
     * @return 结果
     */
    @Override
    public int updateCompIndividualRegistration(CompIndividualRegistration compIndividualRegistration) {
        return compIndividualRegistrationMapper.updateCompIndividualRegistration(compIndividualRegistration);
    }

    /**
     * 批量删除个人报名
     *
     * @param registrationIds 需要删除的个人报名主键
     * @return 结果
     */
    @Override
    public int deleteCompIndividualRegistrationByRegistrationIds(String registrationIds) {
        return compIndividualRegistrationMapper.deleteCompIndividualRegistrationByRegistrationIds(Convert.toStrArray(registrationIds));
    }

    /**
     * 删除个人报名信息
     *
     * @param registrationId 个人报名主键
     * @return 结果
     */
    @Override
    public int deleteCompIndividualRegistrationByRegistrationId(Long registrationId) {
        return compIndividualRegistrationMapper.deleteCompIndividualRegistrationByRegistrationId(registrationId);
    }
}
