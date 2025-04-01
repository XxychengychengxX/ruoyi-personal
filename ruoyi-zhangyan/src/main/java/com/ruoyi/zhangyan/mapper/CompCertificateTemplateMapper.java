package com.ruoyi.zhangyan.mapper;

import com.ruoyi.zhangyan.domain.CompCertificateTemplate;

import java.util.List;

/**
 * 证书模板Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface CompCertificateTemplateMapper {
    /**
     * 查询证书模板
     *
     * @param templateId 证书模板主键
     * @return 证书模板
     */
    public CompCertificateTemplate selectCompCertificateTemplateByTemplateId(Long templateId);

    /**
     * 查询证书模板列表
     *
     * @param compCertificateTemplate 证书模板
     * @return 证书模板集合
     */
    public List<CompCertificateTemplate> selectCompCertificateTemplateList(CompCertificateTemplate compCertificateTemplate);

    /**
     * 新增证书模板
     *
     * @param compCertificateTemplate 证书模板
     * @return 结果
     */
    public int insertCompCertificateTemplate(CompCertificateTemplate compCertificateTemplate);

    /**
     * 修改证书模板
     *
     * @param compCertificateTemplate 证书模板
     * @return 结果
     */
    public int updateCompCertificateTemplate(CompCertificateTemplate compCertificateTemplate);

    /**
     * 删除证书模板
     *
     * @param templateId 证书模板主键
     * @return 结果
     */
    public int deleteCompCertificateTemplateByTemplateId(Long templateId);

    /**
     * 批量删除证书模板
     *
     * @param templateIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompCertificateTemplateByTemplateIds(String[] templateIds);
}
