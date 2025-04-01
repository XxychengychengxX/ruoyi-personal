package com.ruoyi.zhangyan.mapper;

import com.ruoyi.zhangyan.domain.CompIndividualRegistration;

import java.util.List;

/**
 * 个人报名Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface CompIndividualRegistrationMapper {
    /**
     * 查询个人报名
     *
     * @param registrationId 个人报名主键
     * @return 个人报名
     */
    public CompIndividualRegistration selectCompIndividualRegistrationByRegistrationId(Long registrationId);

    /**
     * 查询个人报名列表
     *
     * @param compIndividualRegistration 个人报名
     * @return 个人报名集合
     */
    public List<CompIndividualRegistration> selectCompIndividualRegistrationList(CompIndividualRegistration compIndividualRegistration);

    /**
     * 新增个人报名
     *
     * @param compIndividualRegistration 个人报名
     * @return 结果
     */
    public int insertCompIndividualRegistration(CompIndividualRegistration compIndividualRegistration);

    /**
     * 修改个人报名
     *
     * @param compIndividualRegistration 个人报名
     * @return 结果
     */
    public int updateCompIndividualRegistration(CompIndividualRegistration compIndividualRegistration);

    /**
     * 删除个人报名
     *
     * @param registrationId 个人报名主键
     * @return 结果
     */
    public int deleteCompIndividualRegistrationByRegistrationId(Long registrationId);

    /**
     * 批量删除个人报名
     *
     * @param registrationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompIndividualRegistrationByRegistrationIds(String[] registrationIds);
}
