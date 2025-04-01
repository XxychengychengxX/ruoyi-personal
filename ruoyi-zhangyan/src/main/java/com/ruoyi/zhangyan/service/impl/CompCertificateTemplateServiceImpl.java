package com.ruoyi.zhangyan.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zhangyan.domain.CompCertificateTemplate;
import com.ruoyi.zhangyan.mapper.CompCertificateTemplateMapper;
import com.ruoyi.zhangyan.service.ICompCertificateTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 证书模板Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class CompCertificateTemplateServiceImpl implements ICompCertificateTemplateService {
    @Autowired
    private CompCertificateTemplateMapper compCertificateTemplateMapper;

    /**
     * 查询证书模板
     *
     * @param templateId 证书模板主键
     * @return 证书模板
     */
    @Override
    public CompCertificateTemplate selectCompCertificateTemplateByTemplateId(Long templateId) {
        return compCertificateTemplateMapper.selectCompCertificateTemplateByTemplateId(templateId);
    }

    /**
     * 查询证书模板列表
     *
     * @param compCertificateTemplate 证书模板
     * @return 证书模板
     */
    @Override
    public List<CompCertificateTemplate> selectCompCertificateTemplateList(CompCertificateTemplate compCertificateTemplate) {
        return compCertificateTemplateMapper.selectCompCertificateTemplateList(compCertificateTemplate);
    }

    /**
     * 新增证书模板
     *
     * @param compCertificateTemplate 证书模板
     * @return 结果
     */
    @Override
    public int insertCompCertificateTemplate(CompCertificateTemplate compCertificateTemplate) {
        compCertificateTemplate.setCreateTime(DateUtils.getNowDate());
        return compCertificateTemplateMapper.insertCompCertificateTemplate(compCertificateTemplate);
    }

    /**
     * 修改证书模板
     *
     * @param compCertificateTemplate 证书模板
     * @return 结果
     */
    @Override
    public int updateCompCertificateTemplate(CompCertificateTemplate compCertificateTemplate) {
        return compCertificateTemplateMapper.updateCompCertificateTemplate(compCertificateTemplate);
    }

    /**
     * 批量删除证书模板
     *
     * @param templateIds 需要删除的证书模板主键
     * @return 结果
     */
    @Override
    public int deleteCompCertificateTemplateByTemplateIds(String templateIds) {
        return compCertificateTemplateMapper.deleteCompCertificateTemplateByTemplateIds(Convert.toStrArray(templateIds));
    }

    /**
     * 删除证书模板信息
     *
     * @param templateId 证书模板主键
     * @return 结果
     */
    @Override
    public int deleteCompCertificateTemplateByTemplateId(Long templateId) {
        return compCertificateTemplateMapper.deleteCompCertificateTemplateByTemplateId(templateId);
    }
}
